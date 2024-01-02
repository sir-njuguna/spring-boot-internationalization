
## Spring boot internationalization

| Java version           | 17      |
|------------------------|---------|
| Spring boot version    | 3.2.1   |


Internationalization is the process of making your application adaptable to various languages and regions 
without altering the core source code.

In this demo, we will guide you through the process of delivering messages in different languages based on 
the user's locale.

### Message source definition
First we set up a `MessageSource` bean and define the base names of our messages.

A `MessageSource` provides a way to externalize and manage messages, 
making it easier to support multiple languages and regions without modifying the application code.

The `MessageSource` interface provides methods for retrieving messages based on a given `key` and `locale`.

The code snippet below illustrates how to set up a message source bean.

```java
...

@Bean
public MessageSource messageSource(){
    ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
    source.addBasenames("classpath:messages");
    source.setCacheSeconds(3600);
    return source;
}

...
```

We define the base names as the `messages` bundle in the applications classpath.
The `addBasenames(...)` accepts multiple paths from which the messages have been defined. 
In this case, we've defined the messages under the resources folder of our project.

![Screenshot from 2024-01-02 13-21-06.png](..%2F..%2F..%2F..%2FPictures%2FScreenshots%2FScreenshot%20from%202024-01-02%2013-21-06.png)

Files for each locale should be named as `messages_xx.properties`, where the '`xx`' represents the locale code.
The table below shows some sample messages properties files and their corresponding locales.

| Properties file        | Locale  |
|------------------------|---------|
| messages_en.properties | English |
| messages.fr.properties | French  |
| messages.sv.properties | Swedish |
| messages.sw.properties | Swahili |

Message properties are key/value pairs where the value changes based on the locale.

EG,\
`hello.message = Hello world.` in English\
and\
`hello.message = Bonjour le monde.` in French

### Getting messages
To retrieve a message we pass the message key and the locale to a `MessageResource` instance.\
EG,`messageSource.getMessage("hello.message", null, locale);`\
The `getMessage(...)` received three arguments, a message key, an array of arguments to format the message, and the locale.

### Injecting locale
From the controller method, one can retrieve the locale as an argument.\
Spring boot shall extract the locale from the request headers and pass it to the method.

The code snippet below illustrates this concept.

```java

@GetMapping("hello")
public String hello(Locale locale){
    return messageSource.getMessage("hello.message", null, locale);
}

```

To specify the locale in the http request, pass the `Accept-Language` in the headers.

Eg: `curl localhost:8080/hello -H "Accept-Language: en"` 
