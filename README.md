# libSO

This is the version 0.1 of libSO. It provides a convenient way to read and write
a PharmML standard output object (version 0.1) and it provides basic schema based validation.

## Installation
### Prerequisites

* Java JDK 1.6 or newer
* Ant (tested with version 1.8.4)

The project has been tested and is known to work with versions 1.6 and 1.7
of the JDK. Build instructions for both environments are provided below.

### Setting up the project
If you are downloading this distribution from a git repository then
you need to first clone the project to your local machine. The remote
repository will typically tell you how to do this.

In the previous version, latest PharmML schema definitions were fetched from 
repository during the check-out process. This does not occur anymore as there
is no more class auto-generated by XSD files, and we want stable definition files.

#### Java 6

1. First go to the build directory

    cd libPharmML

2. Fetch all dependencies using Ivy.

    ant retrieve

3. Force Java 6 use the latest version of JAXB instead of the one it
comes with. This involves putting ivy_libs/src-build/jaxb-api.jar in
your JRE's endorsed directory. You might use something like

    cp ivy_libs/src-build/jaxb-api.jar $JAVA_HOME/jre/lib/endorsed/

4. Build the jars. This should download all dependencies and then
compile the code. You should end up with three jar files containing
the binary code, the javadoc of the API and the src code.

    ant jar-all
    

#### Java 7
1. Navigate to the libPharmML folder:
    cd libPharmML

2. Open the Ant script and change the values of the properties **source**
and **target** from 1.6 to 1.7.

3. Call the default ant target, jar-all:

    ant


### Fetching libPharmML from Maven
libPharmML is available through the EBI Maven repository:
url: http://www.ebi.ac.uk/~maven/m2repo/
group: eu.ddmore.pharmml
module: libPharmML-SO
version: 0.1-b1

## Getting Started

### Creating LibSO

		SOFactory soFactory = SOFactory.getInstance();
		LibSO libSO = soFactory.createLibSO();


### Creating SO resource

		StandardisedOutputResource soResource = libSO.createDom(SOVersion.DEFAULT);


### Starting populating the SO

		StandardisedOutput so = soResource.getDom();
		so.setImplementedBy("John Doe");


### Adding a reference to the PharmML model

		so.createPharmMLRef("pharmml_model.xml");


### Creating a SOBlock that will contain the results

		SOBlock block = so.createSoBlock();
		block.setBlkId("blk1");
		RawResults results = block.createRawResults();
	    ImportDataType rawFile = results.createRawFile("oi1", "data/results.csv", "CSV", Delimiter.COMMA);
		// etc [...]


### Validating the SO object

		IValidationReport valRep = libSO.getValidator().createValidationReport(soResource);
		for(int i=1;i<=valRep.numErrors();i++){
			System.err.println(valRep.getError(i));
		}


### Saving the file

		libSO.save(new FileOutputStream("/homes/florent/tmp/so_out.xml"), soResource);

		
## Credits

Florent Yvon.

22 Oct 2014.

Copyright EMBL-EBI 2014.
		