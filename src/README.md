**Zuora plugins**

Zuora API represents a rich collection of the objects and is driven by swagger to allow easy management of such big
collection. To drive such big object model - semi-auto-generation is used.  

**How to get Zuora API Swagger definition and prepare it to work:**

Swagger definition file could be found [here](https://community.zuora.com/t5/Developers/How-to-Generate-a-Code-Library-From-the-Zuora-OpenAPI-Spec/gpm-p/23507)

Direct download file link is [here](https://assets.zuora.com/zuora-documentation/swagger.yaml)

After downloading the yaml definition file, it should be converted to json format and placed to `src\test\resources\swagger.json`


**How to generate object classes**
- using Zuora `describe` API
```java
   ZuoraRestClient client = new ZuoraRestClient(
     "https://rest.apisandbox.zuora.com",
     "username",
     "password",
     true
   );
   client.getObjectList().dumpToDirectory(client, "folder location to store objects");
```

- using swagger definitions
```java
    SwaggerTransformer transformer = new SwaggerTransformer(Paths.get(ClassLoader.getSystemClassLoader()
        .getResource("swagger.json").toURI()));

    ZuoraDefinitions definitions = transformer.getDefinitions();
    definitions.dumpToDirectory(null, "folder location to store objects");
```

 
Auto-generated classes namespace: `io.cdap.plugin.zuora.objects.*`

Supported objects configuration class: `io.cdap.plugin.zuora.RestObjectsConfig` 
