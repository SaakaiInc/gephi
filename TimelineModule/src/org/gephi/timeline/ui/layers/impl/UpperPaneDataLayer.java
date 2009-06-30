/*
Copyright 2008 WebAtlas
Authors : Mathieu Bastian, Mathieu Jacomy, Julian Bilcke
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * UpperPaneDataLayer.java
 *
 * Created on Jun 21, 2009, 3:48:59 PM
 */
package org.gephi.timeline.ui.layers.impl;

import org.gephi.timeline.ui.FakeTimelineDataModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.gephi.timeline.api.TimelineDataModel;

/**
 *
 * @author Julian Bilcke
 */
public class UpperPaneDataLayer extends DefaultDataLayer {

    private static final long serialVersionUID = 1L;

    /** Creates new form UpperPaneDataLayer */
    public UpperPaneDataLayer() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(skin.getRenderingHints());

        skin.compileDataLayerPaint(getWidth(), getHeight());

        int dataSampleSize = getWidth() / 5;
        if (dataSampleSize < 1)  dataSampleSize = 1;
        List<Float> data = model.getDataSample(dataSampleSize);

        GeneralPath chart = new GeneralPath(GeneralPath.WIND_EVEN_ODD, data.size() + 1);

        chart.moveTo(0, getHeight());
        int i = 0;
        for (Float f : data) {
            chart.lineTo((int) (i++ * ((float) (getWidth())) / (float) (data.size())),
                    (int) (f * getHeight()));
        }
        chart.lineTo(getWidth(), getHeight());

        //oddShape.curveTo(10, 90, 100, 50, 34, 99);
        chart.closePath();

        g2d.setPaint(skin.getDataLayerPaint());
        g2d.fill(chart);

        //g2d.setPaint(Color.black);
        g2d.setColor(skin.getDataLayerStrokeColor());
        g2d.setStroke(skin.getDataLayerStroke());
        g2d.draw(chart);

    // GeneralPath shape = new GeneralPath();
    // System.out.println("x: "+(getWidth()/2)+"y: "+getHeight());

    //shape.quadTo(3, 3, 4, 4);
    //shape.curveTo(5, 5, 6, 6, 7, 7);

        g2d.setFont(new Font("DejaVu Sans Mono", 0, 12));
        g2d.drawString("1 january 1970", 10, 12);


    //layer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
    //Graphics2D graphics2d = layer.createGraphics();
    //graphics2d.setRenderingHints(antialiasingHints);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
