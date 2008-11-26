/*
 * Copyright 2008 Google Inc.
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
package com.google.gwt.maps.client;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.maps.client.event.MapTypeNewCopyrightHandler;
import com.google.gwt.maps.client.event.NewCopyrightHandler;
import com.google.gwt.maps.client.event.TileLayerNewCopyrightHandler;
import com.google.gwt.maps.client.event.MapTypeNewCopyrightHandler.MapTypeNewCopyrightEvent;
import com.google.gwt.maps.client.event.NewCopyrightHandler.NewCopyrightEvent;
import com.google.gwt.maps.client.event.TileLayerNewCopyrightHandler.TileLayerNewCopyrightEvent;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.geom.LatLngBounds;
import com.google.gwt.maps.client.geom.Point;

/**
 * Tests the 'newcopyright' events in {@link CopyrightCollection},
 * {@link TileLayer}, and {@link MapType} classes.
 * 
 */
public class CopyrightEventTests extends GWTTestCase {

  // Length of time to wait for asynchronous test to complete.
  static final int ASYNC_DELAY_MSEC = 5000;

  /**
   * shared routine to generate a bogus {@link TileLayer}. 
   * @param collection an initialized copyright collection
   * @return an initialized TileLayer instance.
   */
  private static TileLayer getTileLayer(CopyrightCollection collection) {
    return  new TileLayer(collection, 1, 9) {

      @Override
      public double getOpacity() {
        return 1.0;
      }

      @Override
      public String getTileURL(Point tile, int zoomLevel) {
        return "http;//localhost/tile.png";
      }

      @Override
      public boolean isPng() {
        return true;
      }
      
    };
  }

  @Override
  public String getModuleName() {
    return "com.google.gwt.maps.GoogleMapsTest";
  }

  public void testCopyrightCollectionEvent() {
    LatLngBounds bounds = new LatLngBounds(new LatLng(-90.0, -180.0),
        new LatLng(90.0, 180.0));
    final CopyrightCollection collection = new CopyrightCollection();
    final Copyright copyright = new Copyright(3452981, bounds, 3, "2008 Google");
    collection.addNewCopyrightHandler(new NewCopyrightHandler() {

      public void onNewCopyright(NewCopyrightEvent event) {
        assertEquals(event.getSender(), collection);
        assertEquals(event.getCopyright(), copyright);
        finishTest();
      }

    });
    delayTestFinish(ASYNC_DELAY_MSEC);
    collection.addCopyright(copyright);
  }

  public void testCopyrightCollectionTrigger() {
    LatLngBounds bounds = new LatLngBounds(new LatLng(-90.0, -180.0),
        new LatLng(90.0, 180.0));
    final CopyrightCollection collection = new CopyrightCollection();
    final Copyright copyright = new Copyright(3432241, bounds, 3, "2008 Google");
    collection.addNewCopyrightHandler(new NewCopyrightHandler() {

      public void onNewCopyright(NewCopyrightEvent event) {
        assertEquals(event.getSender(), collection);
        assertEquals(event.getCopyright(), copyright);
        finishTest();
      }

    });
    delayTestFinish(ASYNC_DELAY_MSEC);
    collection.trigger(new NewCopyrightEvent(collection, copyright));
  }

// TODO(zundel): This test fires, but returns NULL for the copyright parameter.  
  
//  public void testMapTypeEvent() {
//    MapWidget map = new MapWidget();
//    LatLngBounds bounds = new LatLngBounds(new LatLng(-90.0, -180.0),
//        new LatLng(90.0, 180.0));
//    final Copyright copyright = new Copyright(83432, bounds, 3, "2008 Google");
//    final Copyright copyright2 = new Copyright(17324, bounds, 2, "2007-2008 Google");
//    CopyrightCollection collection = new CopyrightCollection();
//    collection.addCopyright(copyright);
//    final TileLayer tileLayer = getTileLayer(collection);
//    TileLayer[] layers = new TileLayer[1];
//    layers[0] = tileLayer;
//    final MapType mapType = new MapType(layers, new MercatorProjection(9), "unit test map type");
//    mapType.addMapTypeNewCopyrightHandler(new MapTypeNewCopyrightHandler() {
//
//      public void onNewCopyright(MapTypeNewCopyrightEvent event) {
//        assertEquals(mapType, event.getSender());
//        assertEquals(copyright2, event.getCopyright());
//        finishTest();
//      }
//
//    });
//  
//    map.addMapType(mapType);
//    
//    delayTestFinish(ASYNC_DELAY_MSEC);
//    collection.addCopyright(copyright2);
//  }
  
  public void testMapTypeTrigger() {
    final MapType mapType = MapType.getNormalMap();
    LatLngBounds bounds = new LatLngBounds(new LatLng(-90.0, -180.0),
        new LatLng(90.0, 180.0));
    final Copyright copyright = new Copyright(123432, bounds, 3, "2008 Google");

    mapType.addMapTypeNewCopyrightHandler(new MapTypeNewCopyrightHandler() {

      public void onNewCopyright(MapTypeNewCopyrightEvent event) {
        assertEquals(event.getSender(), mapType);
        assertEquals(event.getCopyright(), copyright);
        finishTest();
      }

    });
    delayTestFinish(ASYNC_DELAY_MSEC);
    mapType.trigger(new MapTypeNewCopyrightEvent(mapType, copyright));
  }
  
//TODO(zundel): This test fires, but returns NULL for the copyright parameter.  
  
//  public void testTileLayerEvent() {
//    MapWidget map = new MapWidget();
//    LatLngBounds bounds = new LatLngBounds(new LatLng(-90.0, -180.0),
//        new LatLng(90.0, 180.0));
//    final Copyright copyright = new Copyright(43432, bounds, 3, "2008 Google");
//    final Copyright copyright2 = new Copyright(77324, bounds, 2, "2007-2008 Google");
//    CopyrightCollection collection = new CopyrightCollection();
//    collection.addCopyright(copyright);
//    final TileLayer tileLayer = getTileLayer(collection);
//    TileLayer[] layers = new TileLayer[1];
//    layers[0] = tileLayer;
//    MapType mapType = new MapType(layers, new MercatorProjection(9), "unit test map type");
//    map.addMapType(mapType);
//    
//    delayTestFinish(ASYNC_DELAY_MSEC);
//    collection.addCopyright(copyright2);
//  }
  
  public void testTileLayerTrigger() {
    LatLngBounds bounds = new LatLngBounds(new LatLng(-90.0, -180.0),
        new LatLng(90.0, 180.0));
    final Copyright copyright = new Copyright(123432, bounds, 3, "2008 Google");
    CopyrightCollection collection = new CopyrightCollection();
    collection.addCopyright(copyright);
    final TileLayer tileLayer = getTileLayer(collection);
    tileLayer.addTileLayerNewCopyrightHandler(new TileLayerNewCopyrightHandler() {

      public void onNewCopyright(TileLayerNewCopyrightEvent event) {
        assertEquals(event.getSender(), tileLayer);
        assertEquals(event.getCopyright(), copyright);
        finishTest();
      }

    });
    delayTestFinish(ASYNC_DELAY_MSEC);
    tileLayer.trigger(new TileLayerNewCopyrightEvent(tileLayer, copyright));
  }
}