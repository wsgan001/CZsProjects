package org.nust.heroine.basicstruct;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

/**
 * Petri网中的库所
 * 
 * @author Administrator
 * 
 */
public class Place extends Node {

	private static final long serialVersionUID = 1L;

	public Place() {
		super();
		this.type = "place";
	}

	public Place(String Name) {
		this.Name = Name;
	}

	public Place(String Name, int DX, int DY, int PX, int PY) {
		this.Name = Name;
		this.DX = DX;
		this.DY = DY;
		this.PX = PX;
		this.PY = PY;
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Color c = g2d.getColor();
		Stroke s = new BasicStroke(2.0f);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(s);
		g2d.drawOval(PX, PY, DX, DY);
		g2d.setColor(Color.RED);
		Font f = new Font("time new romans", Font.BOLD, 14);
		g2d.setFont(f);
		g2d.drawString(ID, PX + 7, PY + 13);
		g2d.setColor(c);
	}

	public Rectangle getRect() {
		return new Rectangle(PX, PY, DX, DY);
	}

}
