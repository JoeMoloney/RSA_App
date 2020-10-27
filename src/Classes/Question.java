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
public class Question
{

//	private ImageIcon icon;
	private String answer;
	private String incorrectAns1;
	private String incorrectAns2;
	private String incorrectAns3;

	public Question(){}
	
	public Question(String answer, String incorrectAns1, String incorrectAns2, String incorrectAns3)
	{
//		this.icon = icon;
		this.answer = answer;
		this.incorrectAns1 = incorrectAns1;
		this.incorrectAns2 = incorrectAns2;
		this.incorrectAns3 = incorrectAns3;
	}

//	public ImageIcon getIcon()
//	{
//		return icon;
//	}

//	public void setIcon(ImageIcon icon)
//	{
//		this.icon = icon;
//	}

	public String getAnswer()
	{
		return answer;
	}

	public void setAnswer(String answer)
	{
		this.answer = answer;
	}

	public String getIncorrectAns1()
	{
		return incorrectAns1;
	}

	public void setIncorrectAns1(String incorrectAns1)
	{
		this.incorrectAns1 = incorrectAns1;
	}

	public String getIncorrectAns2()
	{
		return incorrectAns2;
	}

	public void setIncorrectAns2(String incorrectAns2)
	{
		this.incorrectAns2 = incorrectAns2;
	}

	public String getIncorrectAns3()
	{
		return incorrectAns3;
	}

	public void setIncorrectAns3(String incorrectAns3)
	{
		this.incorrectAns3 = incorrectAns3;
	}
	
}
