package com.miet.cs;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MonthMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String line[]=value.toString().split("\t");
		String date=line[0];
		char a=date.charAt(5);
		String mon=String.valueOf(a);
		a=date.charAt(6);
		mon+=String.valueOf(a);
		a=date.charAt(7);
		mon+=String.valueOf(a);
		a=date.charAt(8);
		mon+=String.valueOf(a);
		a=date.charAt(9);
		mon+=String.valueOf(a);
		String Product=line[1];
		
		context.write(new Text(mon+" "+Product),new IntWritable(1));
	}

}
