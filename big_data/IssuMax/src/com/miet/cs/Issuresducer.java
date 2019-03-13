package com.miet.cs;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Issuresducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int count=0;
		int max=Integer.MAX_VALUE;
		Iterator value=values.iterator();
		while(value.hasNext())
		{
			IntWritable i=(IntWritable) value.next();
			count+=i.get();
		}
	   
		
		context.write(key, new IntWritable(count));
	}

}
