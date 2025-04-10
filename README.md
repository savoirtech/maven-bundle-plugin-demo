# Maven Bundle Plugin Demo

This repository provides a small Java application which provides a playground for exploring Maven Bundle Plugin.

## Create Bundle Project

Apache Karaf provides a useful archetype to generate project boiler plate for building OSGi Bundles. We use this to generate our project skeleton.

```text
mvn archetype:generate \
    -DarchetypeGroupId=org.apache.karaf.archetypes \
    -DarchetypeArtifactId=karaf-bundle-archetype \
    -DarchetypeVersion=4.4.7 \
    -DgroupId=com.mycompany \
    -DartifactId=com.mycompany.bundle \
    -Dversion=1.0.0-SNAPSHOT \
    -Dpackage=com.mycompany.package
```

## Sample Project Structure

Our sample bundle project consists of a public API, an Implementation, an Utilities, and Command package.

```text
com.savoir.bundle.demo.api
com.savoir.bundle.demo.impl
com.savoir.bundle.demo.utils
com.savoir.bundle.demo.command
```

Combined, these packages implement a service with Karaf console command to exercise the code.

## Build

```text
cd sample
mvn clean install
```

## Deploy to Karaf

```text
feature:install scr
install mvn:com.savoir.bundle.demo/sample/1.0.0-SNAPSHOT
```

## Reading the generated Manifest file

```text
Manifest-Version: 1.0
Bnd-LastModified: 1744293038991
Build-Jdk-Spec: 21
Bundle-Activator: com.savoir.bundle.demo.impl.Activator
Bundle-Description: Sample OSGi bundle project.
Bundle-ManifestVersion: 2
Bundle-Name: Sample Bundle
Bundle-SymbolicName: sample
Bundle-Version: 1.0.0.SNAPSHOT
Created-By: Apache Maven Bundle Plugin 5.1.9
Export-Package: com.savoir.bundle.demo.api;version="1.0.0.SNAPSHOT"
Import-Package: com.savoir.bundle.demo.api;version="[1.0,2)",java.io,jav
 a.lang,java.lang.invoke,org.apache.karaf.shell.api.action;version="[4.4
 ,5)",org.apache.karaf.shell.api.action.lifecycle;version="[4.4,5)",org.
 osgi.framework;version="[1.10,2)"
Karaf-Commands: com.savoir.bundle.demo.command
Require-Capability: osgi.ee;filter:="(&(osgi.ee=JavaSE)(version=17))"
Tool: Bnd-6.3.1.202206071316
```
