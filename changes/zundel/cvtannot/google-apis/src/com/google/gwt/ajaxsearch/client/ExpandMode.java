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
package com.google.gwt.ajaxsearch.client;

import com.google.gwt.jsio.client.JSOpaque;

/**
 * Determines how results are initially displayed in a SearchControl. The user
 * will be able to change the display mode by interacting with the
 * SearchControl.
 * 
 * @see SearchControlOptions#add(Search, ExpandMode)
 */
public final class ExpandMode extends JSOpaque {
  /**
   * Results are not immediately displayed.
   */
  public static final ExpandMode CLOSED = new ExpandMode("CLOSED");

  /**
   * All results for a Search are displayed.
   */
  public static final ExpandMode OPEN = new ExpandMode("OPEN");

  /**
   * A subset of the results for a Search are initially displayed.
   */
  public static final ExpandMode PARTIAL = new ExpandMode("PARTIAL");

  private ExpandMode(String mode) {
    super("$wnd.GSearchControl.EXPAND_MODE_" + mode);
  }
}
