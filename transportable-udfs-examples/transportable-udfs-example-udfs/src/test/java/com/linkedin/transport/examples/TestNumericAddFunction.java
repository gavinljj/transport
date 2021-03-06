/**
 * Copyright 2018 LinkedIn Corporation. All rights reserved.
 * Licensed under the BSD-2 Clause license.
 * See LICENSE in the project root for license information.
 */
package com.linkedin.transport.examples;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.linkedin.transport.api.udf.StdUDF;
import com.linkedin.transport.api.udf.TopLevelStdUDF;
import com.linkedin.transport.test.AbstractStdUDFTest;
import com.linkedin.transport.test.spi.StdTester;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;


public class TestNumericAddFunction extends AbstractStdUDFTest {

  @Override
  protected Map<Class<? extends TopLevelStdUDF>, List<Class<? extends StdUDF>>> getTopLevelStdUDFClassesAndImplementations() {
    return ImmutableMap.of(NumericAddFunction.class,
        ImmutableList.of(NumericAddIntFunction.class, NumericAddLongFunction.class));
  }

  @Test
  public void testNumericAdd() {
    StdTester tester = getTester();
    tester.check(functionCall("numeric_add", 1, 2), 3, "integer");
    tester.check(functionCall("numeric_add", 1L, 2L), 3L, "bigint");
  }
}
