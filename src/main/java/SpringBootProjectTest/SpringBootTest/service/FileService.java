package SpringBootProjectTest.SpringBootTest.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import SpringBootProjectTest.SpringBootTest.model.EntityClass;
import SpringBootProjectTest.SpringBootTest.repository.FileRepo;

@Service
public class FileService {

	@Autowired
	private FileRepo repo;

	public String uploadFile(MultipartFile file) throws IOException {
		
		String fileType="text/csv";
		if(!file.getContentType().equals(fileType))
            return "Please Upload CSV file";
		else{
		List<EntityClass> currency=readFile(file.getInputStream());
		System.out.println("curency "+currency);
		repo.saveAll(currency);
		return "File was successfully read and saved to the database";
		}
	}

	private List<EntityClass> readFile(InputStream file) {

		List<EntityClass> dataList=new ArrayList<>();
		try(BufferedReader reader=new BufferedReader(new InputStreamReader(file,"UTF-8"))){
			String line;
			reader.readLine();  //skipping first line because it always heading
			while((line=reader.readLine())!=null){
				String[] values=line.split(",");
				EntityClass entity=new EntityClass();
				entity.setId(Integer.parseInt(values[0].trim()));
				entity.setCode(values[1].trim());
				entity.setName(values[2].trim());
				dataList.add(entity);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return dataList;
	}
	
	public String createNewData(EntityClass entity) throws IOException
	{
		repo.save(entity);
		String file="/home/lokesh/Downloads/currency(1).csv";
		try(FileWriter writer=new FileWriter(file,true)){
			if(new File(file).length()==0)
			     writer.write("Id,Code,Name\n");
			writer.write(entity.getId()+","+entity.getCode()+","+entity.getName()+"\n");
			return "File wass Successfully written to currency.csv";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}
	
	public List<EntityClass> getAllData()
	{
		return repo.findAll();
	}
	
	public EntityClass getDataById(int Id)
	{
		return repo.findById(Id).orElse(null);
	}
	
	public EntityClass updateData(int Id,EntityClass entity)
	{
		EntityClass getById= repo.findById(Id).orElse(null);
		getById.setId(Id);
		getById.setCode(entity.getCode());
		getById.setName(entity.getName());
		return repo.save(getById);
	}
}
