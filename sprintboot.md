

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