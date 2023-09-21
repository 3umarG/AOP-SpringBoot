# AOP in Spring Boot

## What is AOP ??

- **Aspects** are a way the framework intercepts method calls and possibly alters the execution of methods. You can affect the execution of specific method calls you select. This technique helps you extract part of the logic belonging to the executing method. In certain scenarios, decoupling a part of the code helps make that method easier to understand.
- It allows the developer to focus only on the relevant details discussed when reading the method logic.
- Sometimes it’s not relevant to have parts of the code in the same place with the business logic because it makes the app more difficult to understand "**Single Responsibility**". A solution is to move part of the code aside from the business logic implementation using aspects. 
- Also, to apply **Decoupling**.

****

## How aspects work in Spring ??

1. **aspect** : the logic you need to perform and separate aside from the main method (e.g. logging / authentication / proxies ... etc.) 
2. **advice** : *when* the timing of implement the aspect from the target/main method (e.g. before/after/during ... etc.)
3. **pointcut** : *which* method you want to intercept with your aspect 
4. **join point** : which state you want to intercept the **pointcut** (e.g. `execution`,`afterReturned`,`afterThrown`)
5. **target object** : the bean contains the **pointcut**/actual method.

The aspect terminology. Spring executes some logic (**the aspect**) when someone calls a specific method (**the pointcut**). We need to specify when the logic is executed according to the pointcut (e.g., **before**). The when is the **advice**. For Spring to intercept the method, the object that defines the intercepted method needs to be a bean in the Spring context. So, the bean becomes the target object of the aspect.

![aspects.png](images%2Faspects.png)

****

## How Spring deals with Aspect targets ??

##### Weaving an aspect. Instead of giving you a reference to the real bean/target , Spring gives you a reference to a proxy object, intercepts the method calls, and manages the aspect logic.

![aspects 2.png](images%2Faspects%202.png)

<br>

##### When a method isn’t aspected, the call goes directly to that method. When we define an aspect for a method, the call goes through the proxy object. The proxy object applies the logic defined by the aspect and then delegates the call to the real method.

![aspects 3.png](images%2Faspects%203.png)

<br>

****

## Implementing aspects with Spring AOP

**To implement an aspect, you follow four easy steps:**
1. First, you need to enable the aspect capability in your app.
2. Then you create an aspect class,
3. define a method, and instruct Spring when and what to intercept.
4. Finally, you implement the aspect logic.

![aspects 4.png](images%2Faspects%204.png)

****

## References
- **Spring Start Here Book** : 6th chapter.