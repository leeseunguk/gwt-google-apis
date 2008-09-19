/*
 * Copyright 2007 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.maps.client.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsio.client.JSFlyweightWrapper;
import com.google.gwt.maps.client.geom.Point;

/**
 * @gwt.beanProperties
 */
public interface PointImpl extends JSFlyweightWrapper {

  /**
   * @gwt.constructor $wnd.GPoint
   */
  public JavaScriptObject construct(double x, double y);

  public boolean equals(JavaScriptObject jso, Point other);

  public int getX(JavaScriptObject jso);

  public int getY(JavaScriptObject jso);

  public String toString(JavaScriptObject jso);

}