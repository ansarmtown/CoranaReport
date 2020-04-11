package com.corana.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.corana.pojo.CoronaStatus;

@Service
public class CoronaService {
	private static String virusURL="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private List<CoronaStatus> status=new ArrayList<>();
	public List<CoronaStatus> getStatus()
	{
		return status;
	}
	@PostConstruct
	@Scheduled(cron ="5 * * * * *" )
	public void fetchVirusData()
	{
		List<CoronaStatus> newstatus=new ArrayList<>();
		try {
			URL url =new URL(virusURL);
			
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			if(con.getResponseCode()==200)
			{
				BufferedReader br =new BufferedReader(new InputStreamReader(con.getInputStream()));
//------------------------------------------System.out.println(br.toString());
				StringBuffer sb= new StringBuffer();
				String line= "";
				while((line=br.readLine())!=null)
				{
					sb.append(line).append("\n");
				}
				StringReader sr =new StringReader(sb.toString());
//------------------------------------------				
				Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(sr);
//------------------------------------------				
				for (CSVRecord record : records) {
					newstatus.add(new CoronaStatus(record.get("Province/State"), record.get("Country/Region"), Integer.parseInt(record.get(record.size()-1))));
				}
				this.status=newstatus;
				System.out.println(status);
				}
			else
			{
				System.out.println("sdsdfsf");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
