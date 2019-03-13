package com.miet.cs;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class mapper1 extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String line[]=value.toString().split("\t");
	 String Product=line[1];
	 
		String state=line[7];
		String zip=line[8];
		context.write(new Text(Product+" "+state+" "+zip), new IntWritable(1));
	 
	}

}
