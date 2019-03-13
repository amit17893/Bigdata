package com.miet.cs;
//program to no. customer satisfied yes and no
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Timely1 extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String line[]=value.toString().split("\t");
		String TimeResponse=line[2];
		context.write(new Text(TimeResponse),new IntWritable(1));
	}

}
