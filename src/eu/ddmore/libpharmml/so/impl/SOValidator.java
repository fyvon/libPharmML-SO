/*******************************************************************************
 * Copyright (c) 2014 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 *******************************************************************************/
package eu.ddmore.libpharmml.so.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.IValidationReport;
import eu.ddmore.libpharmml.impl.LoggerWrapper;
import eu.ddmore.libpharmml.impl.PharmMLSchemaFactory.NamespaceType;
import eu.ddmore.libpharmml.impl.ValidationReportFactory;
import eu.ddmore.libpharmml.so.StandardisedOutputResource;
import eu.ddmore.libpharmml.so.dom.StandardisedOutput;
//import eu.ddmore.libpharmml.validation.SymbolResolver;
import eu.ddmore.libpharmml.validation.PharmMLElementWrapper;
import eu.ddmore.libpharmml.validation.Validatable;

public class SOValidator {

//	private static final String CONTEXT_NAME = Messages.getString("SOMarshaller.contextDefn"); //$NON-NLS-1$

	public IValidationReport createValidationReport(StandardisedOutputResource resource) {
		try{
			StandardisedOutput dom = resource.getDom();
			
			String writtenVersion = dom.getWrittenVersion();
			SOVersion docVersion = null;
			if(writtenVersion != null){
				docVersion = SOVersion.getEnum(writtenVersion);
			}
			if(docVersion == null){
				docVersion = SOVersion.DEFAULT;
				LoggerWrapper.getLogger().warning("Missing or unknown writtenVersion of SO document. Using default version ("+docVersion+").");
			}

//			JAXBContext jc = JAXBContext.newInstance(CONTEXT_NAME);
//			JAXBSource source = new JAXBSource(jc, dom);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			SOMarshaller m = new SOMarshaller();
			m.marshall(dom, baos, new SOMarshalListener(docVersion, new VoidIdFactoryImpl()));
			Source source = new StreamSource(new ByteArrayInputStream(baos.toByteArray()));
	 
			Schema schema = SOSchemaFactory.getInstance().createSOSchema(docVersion, NamespaceType.OLD);
			Validator validator = schema.newValidator();
			final ValidationReportFactory rptFact = new ValidationReportFactory();
			validator.setErrorHandler(new ErrorHandler() {
				
				@Override
				public void warning(SAXParseException exception) throws SAXException {
					rptFact.handleWarning(exception.getMessage());
				}
				
				@Override
				public void fatalError(SAXParseException exception) throws SAXException {
					rptFact.handleError("SCHEMA",exception.getMessage());
				}
				
				@Override
				public void error(SAXParseException exception) throws SAXException {
					rptFact.handleError("SCHEMA",exception.getMessage());
				}
			});
			validator.validate(source);
			
			// symbol resolution
//			SymbolResolver resolver = new SymbolResolver(dom);
//			List<IValidationError> resolvErrors = resolver.resolveSymbols();
//			for(IValidationError error : resolvErrors){
//				rptFact.addError(error);
//			}
//			List<IValidationError> unicityErrors = resolver.checkUnicity();
//			for(IValidationError error : unicityErrors){
//				rptFact.addError(error);
//			}
			
			PharmMLElementWrapper wRoot = new PharmMLElementWrapper(dom);
			recursiveValidate(rptFact, wRoot);
			
			return rptFact.createReport();
		}
		catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
        } catch (SAXException e) {
			throw new RuntimeException(e.getMessage(), e);
        }
	}
	

	private static void recursiveValidate(IErrorHandler errorHandler, PharmMLElementWrapper wEl){
		Object el = wEl.getElement();
		if(el instanceof Validatable){
			LoggerWrapper.getLogger().info("Validating "+el);
			((Validatable)el).validate(errorHandler);
		}
		for(PharmMLElementWrapper wChild : wEl.getChildren()){
			recursiveValidate(errorHandler, wChild);
		}
	}


	
}
