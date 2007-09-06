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
package com.google.gwt.maps.client.geom;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.maps.client.event.MarkerListener;
import com.google.gwt.maps.client.impl.BoundsImpl;
import com.google.gwt.maps.client.util.JsUtil;

/**
 * Represents a rectangular bound.
 * 
 * TODO: This GBounds object appears to be a remnant from an older version of
 * the Google Maps API. In most places it has been replaced by the geographical
 * version GLatLngBounds. It is currently only used in
 * {@link MarkerListener#onChanged(com.google.gwt.maps.client.overlay.MarkerManager, Bounds, int)}.
 */
public final class Bounds {

  static Bounds createPeer(JavaScriptObject jsoPeer) {
    return new Bounds(jsoPeer);
  }

  private final JavaScriptObject jsoPeer;

  public Bounds(Point[] points) {
    jsoPeer = BoundsImpl.impl.construct(JsUtil.toJsList(points));
  }

  public Bounds(int minX, int minY, int maxX, int maxY) {
    jsoPeer = BoundsImpl.impl.construct(minX, minY, maxX, maxY);
  }

  private Bounds(JavaScriptObject jsoPeer) {
    this.jsoPeer = jsoPeer;
  }

  public int getMinX() {
    return BoundsImpl.impl.getMinX(jsoPeer);
  }

  public int getMaxX() {
    return BoundsImpl.impl.getMaxX(jsoPeer);
  }

  public int getMinY() {
    return BoundsImpl.impl.getMinY(jsoPeer);
  }

  public int getMaxY() {
    return BoundsImpl.impl.getMaxY(jsoPeer);
  }

  public String toString() {
    return BoundsImpl.impl.toString(jsoPeer);
  }

  public Point getUpperLeft() {
    return BoundsImpl.impl.min(jsoPeer);
  }

  public Point getLowerRight() {
    return BoundsImpl.impl.max(jsoPeer);
  }

  public boolean containsBounds(Bounds other) {
    return BoundsImpl.impl.containsBounds(jsoPeer, other);
  }

  public Bounds extend(Point point) {
    Bounds bounds = new Bounds(getMinX(), getMinY(), getMaxX(), getMaxY());
    BoundsImpl.impl.extend(bounds.jsoPeer, point);
    return bounds;
  }

  public Bounds intersection(Bounds other) {
    return BoundsImpl.impl.intersection(jsoPeer, other);
  }
}
