/**
 * Copyright 2018 LinkedIn Corporation. All rights reserved.
 * Licensed under the BSD-2 Clause license.
 * See LICENSE in the project root for license information.
 */
package com.linkedin.transport.examples.presto;

import com.linkedin.transport.api.udf.StdUDF;
import com.linkedin.transport.examples.ArrayElementAtFunction;
import com.linkedin.transport.presto.StdUdfWrapper;


public class ArrayElementAtFunctionWrapper extends StdUdfWrapper {
  public ArrayElementAtFunctionWrapper() {
    super(new ArrayElementAtFunction());
  }

  @Override
  protected StdUDF getStdUDF() {
    return new ArrayElementAtFunction();
  }
}
