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
package com.google.gwt.visualization;

import com.google.gwt.junit.tools.GWTTestSuite;
import com.google.gwt.visualization.client.AjaxLoaderTest;
import com.google.gwt.visualization.client.AnnotatedTimeLineTest;
import com.google.gwt.visualization.client.AreaChartTest;
import com.google.gwt.visualization.client.BarChartTest;
import com.google.gwt.visualization.client.ColumnChartTest;
import com.google.gwt.visualization.client.CommonOptionsTest;
import com.google.gwt.visualization.client.DataTableTest;
import com.google.gwt.visualization.client.GaugeTest;
import com.google.gwt.visualization.client.GeoMapTest;
import com.google.gwt.visualization.client.IntensityMapTest;
import com.google.gwt.visualization.client.LineChartTest;
import com.google.gwt.visualization.client.MapVisualizationTest;
import com.google.gwt.visualization.client.MotionChartTest;
import com.google.gwt.visualization.client.PieChartTest;
import com.google.gwt.visualization.client.ScatterChartTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * TestSuite for the Maps API.
 * 
 * Running GWTTestCases as a suite speeds up the execution when you have many
 * classes.
 */
public class VisualizationTestSuite extends GWTTestSuite {
  public static Test suite() {
    TestSuite suite = new TestSuite("Test for the Visualization API");
    suite.addTestSuite(AjaxLoaderTest.class);
    suite.addTestSuite(AnnotatedTimeLineTest.class);
    suite.addTestSuite(AreaChartTest.class);
    suite.addTestSuite(BarChartTest.class);
    suite.addTestSuite(ColumnChartTest.class);
    suite.addTestSuite(CommonOptionsTest.class);
    suite.addTestSuite(DataTableTest.class);
    suite.addTestSuite(GaugeTest.class);
    suite.addTestSuite(GeoMapTest.class);
    suite.addTestSuite(IntensityMapTest.class);
    suite.addTestSuite(LineChartTest.class);
    suite.addTestSuite(MapVisualizationTest.class);
    suite.addTestSuite(MotionChartTest.class);
    suite.addTestSuite(PieChartTest.class);
    suite.addTestSuite(ScatterChartTest.class);
    return suite;
  }
}