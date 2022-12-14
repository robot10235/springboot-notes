

### spring web

maven would add dependency to pom.xml: 

```json
<dependency>
	<groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```



#### spring-boot-starter-web

important dependencies:

1. webmvc	web framework
2. json           parse json data
3. tomcat      http web server



#### controller

Controller: return web page (and data)

RestController: return json data



##### example1

```java
@RestController
public class HelloController {
    @RequestMapping("/user") // front-end needs to visit ./user to use getUser()
    public User getUser() {
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123");
        return user;
    }
}
```



##### example2

```java
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String index(ModelMap map) {
        map.addAttribute("name", "zhangsan");
        return "hello";	// return hello.html
    }
}
```





#### route map

`@RequestMapping`

front-end needs to visit ./user to use getUser()

useful arguments

1. `value`: url path (can use simple regular expression)
2. `method`: http get / post / put / delete

`@GetMapping ` == `@RequestMapping` (method = get)





#### argument pass

@RequestParam

if the parameter name is different, map it to self-defined argument





### advanced

#### static

static resources like photos store in `projectName/src/main/resources/static` in default.

can be visited in `localhost:8080/test.jpg`

want to place the photo not in the root directory but in a new directory, need to add `spring.mvc.static-path-pattern=/images/**` to the `application.properties` file.



#### upload files

`enctype` means how to encode the file data

file should have `enctype="multipart/form-data"` to be uploaded successfully.

default uploaded file maximum size is 1Mb

can be changed in `application.properties` file.

upload files can be stored in a self-defined directory, we can modify the config file to change the static resources path to it to visit uploaded files



#### interceptor

when clients try to visit specific directory, server will know immediately

need to use a config class to register the interceptor





### RESTful

Representational State Transfer

client should use GET POST PUT DELETE to operate the resource in server

resource file is JSON or HTML

stateless client-server communication



#### HTTP method

1. POST
2. GET
3. PUT
4. PATCH
5. DELETE

different return values to notify front-end



status code

- [Informational responses](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#information_responses) (`100`???`199`)
- [Successful responses](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#successful_responses) (`200`???`299`)
- [Redirection messages](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#redirection_messages) (`300`???`399`)
- [Client error responses](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#client_error_responses) (`400`???`499`)
- [Server error responses](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#server_error_responses) (`500`???`599`)



#### Spring Boot implement RESTful API

annotation

- @GetMapping
- @PostMapping
- @PutMapping
- @DeleteMapping
- @PatchMapping



| HTTP   | ADDR     | INFO           |
| ------ | -------- | -------------- |
| POST   | /user    |                |
| GET    | /user/id |                |
| PUT    | /user    |                |
| DELETE | /user/id | delete id user |

delete user id: 10

delete http://localhost/user/10





#### Swagger

gui for RESTful 







### ORM

Object Relational Mapping

help java object mapping to database table



#### MyBatis

ORM Framework



mybatis plus: do not need to write the interfaces

`extends BaseMapper` is enough