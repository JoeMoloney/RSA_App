/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author K00243015
 */
public class RSAImages
{

	private String imageName;
	private String category;
	private String path;

	public RSAImages()
	{
	}

	public RSAImages(String imageName, String category, String path)
	{
		this.imageName = imageName;
		this.category = category;
		this.path = path;
	}

	public String getImageName()
	{
		return imageName;
	}

	public String getCategory()
	{
		return category;
	}

	public String getPath()
	{
		return path;
	}

	public void setImageName(String imageName)
	{
		this.imageName = imageName;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	@Override
	public String toString()
	{
		return String.format("RSAImages:" + "\nimageName: %s, \ncategory: %s, \npath: %s", imageName, category, path);
	}
}
