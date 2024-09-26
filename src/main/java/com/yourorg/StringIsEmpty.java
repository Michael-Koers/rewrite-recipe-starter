/*
 * Copyright 2024 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yourorg;

import com.google.errorprone.refaster.annotation.AfterTemplate;
import com.google.errorprone.refaster.annotation.BeforeTemplate;
import org.openrewrite.java.template.RecipeDescriptor;

// TODO - This is a placeholder for a Refaster recipe. Implement the recipe by adding before and after annotated methods.
// The rule should replace calls to `String.length() == 0` with `String.isEmpty()`, as well as similar variants.
// You're done when all the tests in `StringIsEmptyTest` passes.
@RecipeDescriptor(
        name = "Standardize empty String checks",
        description = "Replace calls to `String.length() == 0` with `String.isEmpty()`."
)
public class StringIsEmpty {

    @RecipeDescriptor(
            name = "String Length Equals Zero",
            description = "Replace calls to `String.length() == 0` with `String.isEmpty()`."
    )
    public static class StringLengthEqualsZero {
        @BeforeTemplate
        boolean before(String expr) {
            return expr.length() == 0;
        }

        @AfterTemplate
        boolean after(String expr) {
            return expr.isEmpty();
        }
    }

    @RecipeDescriptor(
            name = "Zero Equals String Length",
            description = "Replace calls to `0 == String.length()` with `String.isEmpty()`."
    )
    public static class ZeroEqualsStringLength {
        @BeforeTemplate
        boolean before(String expr) {
            return 0 == expr.length();
        }

        @AfterTemplate
        boolean after(String expr) {
            return expr.isEmpty();
        }
    }

    @RecipeDescriptor(
            name = "String Length Smaller Than 1",
            description = "Replace calls to `String.length() < 1` with `String.isEmpty()`."
    )
    public static class StringLengthSmallerThan1 {
        @BeforeTemplate
        boolean before(String expr) {
            return expr.length() < 1;
        }

        @AfterTemplate
        boolean after(String expr) {
            return expr.isEmpty();
        }
    }

    @RecipeDescriptor(
            name = "1 Bigger Than String Length",
            description = "Replace calls to `1 > String.length()` with `String.isEmpty()`."
    )
    public static class OneBiggerThanStringLength {
        @BeforeTemplate
        boolean before(String expr) {
            return 1 > expr.length();
        }

        @AfterTemplate
        boolean after(String expr) {
            return expr.isEmpty();
        }
    }

    @RecipeDescriptor(
            name = "String Length Equals Empty String",
            description = "Replace calls to `String.equals('')` with `String.isEmpty()`."
    )
    public static class StringLengthEqualsEmptyString {
        @BeforeTemplate
        boolean before(String expr) {
            return expr.equals("");
        }

        @AfterTemplate
        boolean after(String expr) {
            return expr.isEmpty();
        }
    }

    public static class EmptyStringEqualsStringLength {
        @BeforeTemplate
        boolean before(String expr) {
            return "".equals(expr);
        }

        @AfterTemplate
        boolean after(String expr) {
            return expr.isEmpty();
        }
    }


}
