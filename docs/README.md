## Value

* Basic implementation: 10 points
* Basic unit tests: 5 points
* Extra credit implementation: 10 points (3 + 7)
* Extra credit unit tests: 5 points

## Basic task

### Definition of GCD

* The GCD of 2 non-zero integers is defined as the largest positive integer that divides evenly (i.e. with no remainder) into both.

* GCD is commutative; that is, GCD(_a_, _b_) = GCD(_b_, _a_).

* For integer values that may be positive or negative, the definition of GCD given above dictates that

    > GCD(_a_, _b_) = GCD(&#124;_a_&#124;, &#124;_b_&#124;)

    That is, the GCD of 2 values, where 1 or both of those values are negative, is equal to the GCD of their absolute values.
    
* If exactly one of the values is zero,

    > GCD(_a_, 0) = GCD(0, _a_) = _a_

* If both _a_ and _b_ are zero, then GCD(_a_, _b_) is undefined.
    
### Euclid's algorithm 

_Euclid's algorithm_ for finding the _greatest common divisor_ (GCD) of 2 integers[^1] is a classic; in fact, it's generally considered to be the oldest algorithm that is still in wide use today (albeit with some refinement in implementation).

Given 2 _positive_ integers, _a_ and _b_, the algorithm is stated as follows:

> While _a_ &ne; 0:
> >
> > If _a_ &ge; _b_,
> >
> > > let _a_ = _a_ - _b_;
> >
> > otherwise, 
> >
> > > let _b_ = _b_ - _a_.
>
> Done: The current value of _b_ is the GCD of the original values of _a_ and _b_.

(In the above pseudocode, please observe the indentation and vertical lines, which indicate structure. For example, the lines to the right of the vertical line extending directly below "While" make up the _body_ of the _while_ iteration structure. Also, remember that "otherwise" is simply a synonym for "else".)

#### Example

Given:
* _a_ = 65
* _b_ = 39

1. 65 &ne; 0 (the _while_ condition is true).
2. 65 &ge; 39 (the _if_ condition is true).
3. let _a_ = _a_ - _b_ = 65 - 39 = 26.
4. 26 &ne; 0 (the _while_ condition is true).
5. 26 &lt; 39 (the _if_ condition is false).
6. let _b_ = _b_ - _a_ = 39 - 26 = 13.
7. 26 &ne; 0 (the _while_ condition is true).
8. 26 &ge; 13 (the _if_ condition is true).
9. let _a_ = _a_ - _b_ = 26 - 13 = 13.
10. 13 &ne; 0 (the _while_ condition is true).
11. 13 &ge; 13 (the _if_ condition is true).
12. let _a_ = _a_ - _b_ = 13 - 13 = 0.
13. 0 = 0 (the _while_ condition is false).
14. Done: The current value of _b_ (13) is the GCD of the original values of _a_ and _b_, 65 and 39.

### Implementation 

Implement Euclid's algorithm to complete the `edu.cnm.deepdive.Algorithms.gcd` method, declared as:

```java
public static long gcd(long a, long b) throws IllegalArgumentException
```

For more method declaration details, see the [Javadoc documentation](api/edu/cnm/deepdive/Algorithms.html#gcd(long,long)).

Your implementation should support parameter values that are positive, negative, or zero: 

* If either or both parameter values are negative, you should use their absolute values in Euclid's algorithm.

* If both parameter values are zero, your implementation must throw an `IllegalArgumentException`. (Remember that when you throw an exception, that exception is an object instance; in a case like this, that means you'll have to create a new instance of that class, and then throw it.)

* If just one parameter value is zero, your implementation should return the absolute value of the non-zero-valued parameter.

### Restrictions

* You are expected to _implement_ Euclid's algorithm, **not** simply invoke an existing implementation of that algorithm (e.g. from a 3<sup>rd</sup>-party library, or even from the Java standard library).

### Unit tests

For unit testing credit, use JUnit5 to verify your code with the following inputs and expected outputs:

| `a` | `b` | Expected value of `gcd(a, b)` | Expected exception |
|:---:|:---:|:-----------------------------:|:------------------:|
| `65` | `39` | `13` | (none) |
| `39` | `65` | `13` | (none) |
| `-65` | `39` | `13` | (none) |
| `65` | `-39` | `13` | (none) |
| `-65` | `-39` | `13` | (none) |
| `65` | `0` | `65` | (none) |
| `0` | `39` | `39` | (none) |
| `65` | `119` | `1` | (none) |
| `12319` | `9017` | `127` | (none) |
| `0` | `0` | (none) | `IllegalArgumentException` |

### Hints

* Remember that the pseudocode above only deals with positive integers; thus, your implementation must not only implement that logic, but must also handle the rest of the cases included in the GCD definition&mdash;that is, where one or both parameter values are negative, and where one or both of the values are zero.

* Your implementation need not be a line-by-line translation (from pseudocode to Java) of the above articulation of Euclid's algorithm.

* The method to be completed is `static`; there is no need to create instances of `Algorithms` (and arguably no benefit in doing so).

* You may find it useful to create one or more additional `static` methods as "helpers"; however, the problem can be solved without doing so.

* Don't hesitate to declare any constants (`static final` fields) that you feel might simplify or clarify your code.

* When defining local variables (or `static` fields), remember that the parameters and return value of the `gcd` method are all of the `long` type, not `int`. 

* The method to be completed includes a `TODO` comment to that effect. Please pay attention to the code comments and method names; in particular, don't write your implementation code for the basic task in the body of the extra credit method.

## Extra credit 1

Notice that the pseudocode for [Euclid's algorithm](#euclids-algorithm) will often result in repeated subtractions. If, at any point, one of the 2 values, _a_ and _b_, is much larger than the other, the algorithm can be made much more efficient by using the modulo operator, instead of subtraction. For example, if _a_ = 126 and _b_ = 3, it would take 42 subtractions of _b_ from _a_ before _a_ reaches a value of 0; if we use _a_ = _a_ mod _b, then this happens in a single step.

On the other hand, using modulo, it is possible that rather than _a_ reaching 0, _b_ might reach 0 (i.e. when evaluating _b_ = _b_ mod _a_)&mdash;in which case, we're done with the algorithm, but the GCD at that point is the current value of _a_, rather than _b_. Thus, when using modulo, we should stop when either _a_ or _b_ reaches _0_, and whichever of the 2 is non-zero, that's the value to return as the GCD.

For 3 points of extra credit, modify your implementation to use modulo instead of subtraction&mdash;but make sure your unit tests still pass!

## Extra credit 2

It can be shown that we can generalize the GCD to more than 2 numbers: GCD(_a_<sub>1</sub>, _a_<sub>2</sub>, _a_<sub>3</sub>, &hellip;) = GCD(GCD(_a_<sub>1</sub>, _a_<sub>2</sub>), _a_<sub>3</sub>, &hellip;)). In other words, to find the GCD of _n_ numbers, we can find the GCD of the first 2, then find the GCD of that first result and the 3<sup>rd</sup> number, and so on. 

For extra credit, you must implement an overload of the `gcd` method that takes a _varargs_ parameter `long` values.

### Implementation

Implement an overload of the `edu.cnm.deepdive.Algorithms.gcd` method, declared as:

```java
public static long gcd(long... values) throws IllegalArgumentException
```

For more method declaration details, see the [Javadoc documentation](api/edu/cnm/deepdive/Algorithms.html#gcd(long...)).

#### Exceptions

Your implementation **must** throw an `IllegalArgumentException` under any of the following conditions:

* The length of `values` is zero.

* The length of `values` is 1, and the single element of `values` is zero.

* 2 or more elements of `values` are zero.

#### Normal operation

Your implementation should compute a "running" GCD:

* Compute the GCD of the first 2 elements of `values`; this is the running GCD.

* While there are additional elements in `values`:

    * Compute the GCD of the running GCD and the next element of `values`; this is the new value of the running GCD.

* The final value of the running GCD should be returned as the result.

If the length of `values` is 1, your implementation must return the same result as if `values` were of length 2, with the same value occurring twice.

For full implementation credit, you should minimize duplicated code: the implementation of this overload should invoke the implementation you completed for the basic task, as appropriate. 

### Unit tests

For unit testing credit on the extra credit portion of the problem, use JUnit5 to verify the correctness of your code with the following inputs and expected outputs:

| `values` | Expected value of `gcd(values)` | Expected exception |
|:--------:|:-------------------------------:|:------------------:|
| (none) | (none) | `IllegalArgumentException` |
| `49` | `49` | (none) |
| `49, 49` | `49` | (none) |
| `182, 78` | `26` | (none) |
| `182, 70, 49` | `7` | (none) |
| `70, 56, 182` | `14` | (none) |
| `55, 182, 70` | `1` | (none) |
| `70, 56, 0, 182` | `14` | (none) |
| (none) | (none) | `IllegalArgumentException` |
| `0` | (none) | `IllegalArgumentException` |
| `0, 70, 56, 182, 0` | (none) | `IllegalArgumentException` |
| `70, 0, 56, 0, 182` | (none) | `IllegalArgumentException` |

### Hints

* When defining local variables (or `static` fields), remember that the parameters and return value of the `gcd` method are all of the `long` type, not `int`. 

* Remember that in the body of a method with a _varargs_ parameter, that parameter is simply treated as an array. 

* Code invoking a method with a _varargs_ parameter (e.g. a test method) may do so by providing zero more parameters of the specified type, or an array with elements of the specified type.

* The method to be completed is `static`; there is no need to create instances of `Algorithms` (and arguably no benefit in doing so).

* You may find it useful to create one or more additional `static` methods as "helpers"; however, the problem can be solved without doing so.

* Don't hesitate to declare any constants (`static final` fields) that you feel might simplify or clarify your code.

* The method to be completed includes a `TODO` comment to that effect. Please pay attention to the code comments and method names; in particular, don't attempt the extra credit method unless you've already completed the basic method.

---

[^1]: Even as described by Euclid, the algorithm isn't limited to integers&mdash;in fact, it can be extended to a wide variety of mathematical entities beyond Euclid's original conception&mdash;but we'll limit ourselves to integers here.