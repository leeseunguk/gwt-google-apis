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
import com.google.gwt.maps.client.impl.ProjectionImpl;

public final class MercatorProjection extends Projection {

  public MercatorProjection(int numZoomLevels) {
    super(ProjectionImpl.impl.constructMercatorProjection(numZoomLevels));
    ProjectionImpl.impl.bind(jsoPeer, this);
  }

  protected MercatorProjection(JavaScriptObject jsoPeer) {
    super(jsoPeer);
  }

  protected Point convertLatLngToPixel(LatLng latlng, int zoomLevel) {
    return ProjectionImpl.impl.fromLatLngToPixel(jsoPeer, latlng, zoomLevel);
  }

  protected LatLng convertPixelToLatLng(Point point, int zoomLevel,
      boolean nofix) {
    return ProjectionImpl.impl.fromPixelToLatLng(jsoPeer, point, zoomLevel, nofix);
  }

  public int getWrapWidth(int zoomLevel) {
    return ProjectionImpl.impl.getWrapWidth(jsoPeer, zoomLevel);
  }

  public boolean tileCheckRange(Point point, int zoomLevel, Size tileSize) {
    return ProjectionImpl.impl.tileCheckRange(jsoPeer, point, zoomLevel, tileSize);
  }

}
