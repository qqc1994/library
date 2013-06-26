// Copyright 2011 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.enterprise.adaptor;

import java.util.Map;

/**
 * Convenience class for implementing {@code DocumentTransform}s.
 * Implementations only need to implement {@link #transform}, although they
 * should also likely have a static factory method as defined in {@link
 * DocumentTransform}.
 */
public abstract class AbstractDocumentTransform implements DocumentTransform {
  private String name = getClass().getName();

  public AbstractDocumentTransform() {}

  /**
   * If {@code name} is {@code null}, the default is used.
   */
  public AbstractDocumentTransform(String name) {
    if (name != null) {
      this.name = name;
    }
  }

  /**
   * Configure this instance with provided {@code config}. Accepts key {@code
   * "name"}. Unknown keys are ignored. This method is
   * intended as a convenience for use in a static factory method.
   */
  protected void configure(Map<String, String> config) {
    String name = config.get("name");
    if (name != null) {
      this.name = name;
    }
  }

  protected void setName(String name) {
    if (name == null) {
      throw new NullPointerException();
    }
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
