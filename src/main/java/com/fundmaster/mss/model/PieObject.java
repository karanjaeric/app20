package com.fundmaster.mss.model;

public class PieObject {

		private String name;
		
		private double count;

		public PieObject() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public void setName(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return this.name;
		}
		
		public void setCount(double count)
		{
			this.count = count;
		}
		
		public double getCount()
		{
			return this.count;
		}

		public PieObject(String name, double count) {
			super();
			this.name = name;
			this.count = count;
		}
}
