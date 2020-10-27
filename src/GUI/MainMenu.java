/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Question;
import Classes.RSAImages;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

/**
 *
 * @author Windows_94
 */
public class MainMenu extends javax.swing.JFrame
{

	//Initialize Arrays
	ArrayList<RSAImages> imgList;
	List<Question>  qList = new ArrayList<>(), qList_en = new ArrayList<>(), qList_fi = new ArrayList<>(), qList_nl = new ArrayList<>(), qList_sv = new ArrayList<>();
	Integer rand_int[] = {0, 1, 2, 3}; //rand_int Array w/elements 0 to 3 - these will index the buttons array
	List<Integer> intList = new ArrayList(Arrays.asList(rand_int)); //move rand_int array into List intList
		
	//Initialize DateFormatting & Calendar
	DateFormat df;
	GregorianCalendar cal = new GregorianCalendar();
	
	//Initialize Locales
	Locale locale;
	Locale locales[] = {new Locale("en"), new Locale("fi"), new Locale("nl"), new Locale("sv")};
	
	//Initialize Resource Bundle
	static ResourceBundle rb = ResourceBundle.getBundle("bundles.rb");
	
	//Initialize primitive variables
	//maxQuestions = total number of questions -1 for user to take
	int count = 0, attempt = 0, correct = 0, maxQuestions = 21;

	/**
	 * Creates new form MainMenu
	 */
	public MainMenu()
	{
		initComponents();
		//List<Question> qList = new ArrayList<>(), qList_en = new ArrayList<>();
		//Set default ResourceBundle
		rb = ResourceBundle.getBundle("bundles.rb_en");
		
		File folder = new File("IMG/Signs/");
		try
		{
			imgList = getAllImages(folder, true); //Get images
			
			Path p = Paths.get("TXT/rb_en.txt"); //Get English Questions
			qList_en = generateQuestionObject(p); //Create English Question Object
			
			p = Paths.get("TXT/rb_fi.txt"); //Get Finnish Questions
			qList_fi = generateQuestionObject(p); //Create Finnish Question Object
			
			p = Paths.get("TXT/rb_nl.txt"); //Get Dutch Questions
			qList_nl = generateQuestionObject(p); //Create Dutch Question Object
			
			p = Paths.get("TXT/rb_sv.txt"); //Get Swedish Questions
			qList_sv = generateQuestionObject(p); //Create Swedish Question Object
			
		} catch (IOException ex){Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);}
		
		qList.addAll(qList_en); //Set default Language to English
		
		df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locales[0]);  //Set date/time local to English
		dtLbl.setText(df.format(cal.getTime())); //Aply locale to label
		
		//Assign names to radio buttons
//		ans1.setName("ans1");
//		ans2.setName("ans2");
//		ans3.setName("ans3");
//		ans4.setName("ans4");
		
		//Initialize buttons with questions
		ans1.setText(qList.get(count).getAnswer());
		ans1.setActionCommand(qList.get(count).getAnswer());
		ans2.setText(qList.get(count).getIncorrectAns1());
		ans2.setActionCommand(qList.get(count).getIncorrectAns1());
		ans3.setText(qList.get(count).getIncorrectAns2());
		ans3.setActionCommand(qList.get(count).getIncorrectAns2());
		ans4.setText(qList.get(count).getIncorrectAns3());
		ans4.setActionCommand(qList.get(count).getIncorrectAns3());
		
		String imageP = imgList.get(count).getPath(); //Get image path
		imgLbl.setIcon(new ImageIcon(imageP)); //Convert to icon and display
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        localeButtonGroup = new javax.swing.ButtonGroup();
        ansButtonGroup = new javax.swing.ButtonGroup();
        lPanel = new javax.swing.JPanel();
        LanguageLbl = new javax.swing.JLabel();
        engLcl = new javax.swing.JRadioButton();
        finLcl = new javax.swing.JRadioButton();
        dutLcl = new javax.swing.JRadioButton();
        sweLcl = new javax.swing.JRadioButton();
        leaderboardPanel = new javax.swing.JPanel();
        dtLbl = new javax.swing.JLabel();
        quizPanel = new javax.swing.JPanel();
        questionPanel = new javax.swing.JPanel();
        qPromptLbl = new javax.swing.JLabel();
        imgLbl = new javax.swing.JLabel();
        answerPanel = new javax.swing.JPanel();
        ans1 = new javax.swing.JRadioButton();
        ans2 = new javax.swing.JRadioButton();
        ans3 = new javax.swing.JRadioButton();
        ans4 = new javax.swing.JRadioButton();
        submitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RSA Main Menu");
        setResizable(false);

        lPanel.setBackground(new java.awt.Color(255, 255, 255));

        LanguageLbl.setText("Language:");
        LanguageLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        localeButtonGroup.add(engLcl);
        engLcl.setSelected(true);
        engLcl.setText("English");
        engLcl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        engLcl.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        engLcl.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                engLclActionPerformed(evt);
            }
        });

        localeButtonGroup.add(finLcl);
        finLcl.setText("Finnish");
        finLcl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        finLcl.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        finLcl.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                finLclActionPerformed(evt);
            }
        });

        localeButtonGroup.add(dutLcl);
        dutLcl.setText("Dutch");
        dutLcl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dutLcl.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        dutLcl.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dutLclActionPerformed(evt);
            }
        });

        localeButtonGroup.add(sweLcl);
        sweLcl.setText("Swedish");
        sweLcl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sweLcl.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sweLcl.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sweLclActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lPanelLayout = new javax.swing.GroupLayout(lPanel);
        lPanel.setLayout(lPanelLayout);
        lPanelLayout.setHorizontalGroup(
            lPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(engLcl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finLcl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dutLcl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sweLcl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(LanguageLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        lPanelLayout.setVerticalGroup(
            lPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LanguageLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dutLcl)
                    .addComponent(engLcl)
                    .addComponent(finLcl)
                    .addComponent(sweLcl)))
        );

        leaderboardPanel.setBackground(new java.awt.Color(255, 255, 255));

        dtLbl.setText("[Date/Time]");

        javax.swing.GroupLayout leaderboardPanelLayout = new javax.swing.GroupLayout(leaderboardPanel);
        leaderboardPanel.setLayout(leaderboardPanelLayout);
        leaderboardPanelLayout.setHorizontalGroup(
            leaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leaderboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dtLbl)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        leaderboardPanelLayout.setVerticalGroup(
            leaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leaderboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dtLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        questionPanel.setBackground(new java.awt.Color(255, 255, 255));

        qPromptLbl.setText("What Does The Following Image Stand For:");

        imgLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout questionPanelLayout = new javax.swing.GroupLayout(questionPanel);
        questionPanel.setLayout(questionPanelLayout);
        questionPanelLayout.setHorizontalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(questionPanelLayout.createSequentialGroup()
                        .addComponent(qPromptLbl)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(imgLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        questionPanelLayout.setVerticalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(qPromptLbl)
                .addGap(18, 18, 18)
                .addComponent(imgLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        answerPanel.setBackground(new java.awt.Color(255, 255, 255));

        ansButtonGroup.add(ans1);
        ans1.setText("ANS_1");
        ans1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ans1ActionPerformed(evt);
            }
        });

        ansButtonGroup.add(ans2);
        ans2.setText("ANS_2");
        ans2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ans2ActionPerformed(evt);
            }
        });

        ansButtonGroup.add(ans3);
        ans3.setText("ANS_3");
        ans3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ans3ActionPerformed(evt);
            }
        });

        ansButtonGroup.add(ans4);
        ans4.setText("ANS_4");
        ans4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ans4ActionPerformed(evt);
            }
        });

        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                submitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout answerPanelLayout = new javax.swing.GroupLayout(answerPanel);
        answerPanel.setLayout(answerPanelLayout);
        answerPanelLayout.setHorizontalGroup(
            answerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(answerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(answerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, answerPanelLayout.createSequentialGroup()
                        .addComponent(ans3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ans4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, answerPanelLayout.createSequentialGroup()
                        .addComponent(ans1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ans2)))
                .addContainerGap())
        );
        answerPanelLayout.setVerticalGroup(
            answerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(answerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(answerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ans1)
                    .addComponent(ans2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(answerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ans4)
                    .addComponent(ans3))
                .addGap(18, 18, 18)
                .addComponent(submitBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout quizPanelLayout = new javax.swing.GroupLayout(quizPanel);
        quizPanel.setLayout(quizPanelLayout);
        quizPanelLayout.setHorizontalGroup(
            quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quizPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(questionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        quizPanelLayout.setVerticalGroup(
            quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quizPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(questionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(quizPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(leaderboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leaderboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quizPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void engLclActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_engLclActionPerformed
    {//GEN-HEADEREND:event_engLclActionPerformed
List<JRadioButton> buttons = new ArrayList<>();
		buttons.add(ans1);
		buttons.add(ans2);
		buttons.add(ans3);
		buttons.add(ans4);	
//Set Date/Time Locale
	df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locales[0]);
	dtLbl.setText(df.format(cal.getTime()));
        
	locale = locales[0];
		
	qList = qList_en; //Set working list of questions to English 
	
	updateStrings(qList, buttons);
	
	buttons = null;
	System.gc(); //Force invoke garbage collecter
    }//GEN-LAST:event_engLclActionPerformed

    private void finLclActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_finLclActionPerformed
    {//GEN-HEADEREND:event_finLclActionPerformed
	List<JRadioButton> buttons = new ArrayList<>();
		buttons.add(ans1);
		buttons.add(ans2);
		buttons.add(ans3);
		buttons.add(ans4);
	//Set Date/Time Locale
	df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locales[1]);
	dtLbl.setText(df.format(cal.getTime()));
        
	locale = locales[1];
	
	qList = qList_fi; //Set working list of questions to Finnish
	
	updateStrings(qList, buttons);
	
	buttons = null;
	System.gc(); //Force invoke garbage collecter
    }//GEN-LAST:event_finLclActionPerformed

    private void dutLclActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dutLclActionPerformed
    {//GEN-HEADEREND:event_dutLclActionPerformed
	List<JRadioButton> buttons = new ArrayList<>();
		buttons.add(ans1);
		buttons.add(ans2);
		buttons.add(ans3);
		buttons.add(ans4);
	//Set Date/Time Locale
	df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locales[2]);
	dtLbl.setText(df.format(cal.getTime()));
        
	locale = locales[2];
		
	qList = qList_nl; //Set working list of questions to Dutch
	
	updateStrings(qList, buttons);
	
	buttons = null;
	System.gc(); //Force invoke garbage collecter
    }//GEN-LAST:event_dutLclActionPerformed

    private void sweLclActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sweLclActionPerformed
    {//GEN-HEADEREND:event_sweLclActionPerformed
	List<JRadioButton> buttons = new ArrayList<>();
		buttons.add(ans1);
		buttons.add(ans2);
		buttons.add(ans3);
		buttons.add(ans4);
		
	//Set Date/Time Locale
	df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locales[3]);
	dtLbl.setText(df.format(cal.getTime()));
        
	locale = locales[3];
		
	qList = qList_sv; //Set working list of questions to Swedish
	
	updateStrings(qList, buttons);
	
	buttons = null;
	System.gc(); //Force invoke garbage collecter
    }//GEN-LAST:event_sweLclActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_submitBtnActionPerformed
    {//GEN-HEADEREND:event_submitBtnActionPerformed
	List<JRadioButton> buttons = new ArrayList<>();
		buttons.add(ans1);
		buttons.add(ans2);
		buttons.add(ans3);
		buttons.add(ans4);
		
	next(qList, buttons);
	
	buttons = null;
	System.gc(); //Force invoke garbage collecter
    }//GEN-LAST:event_submitBtnActionPerformed

    private void ans1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ans1ActionPerformed
    {//GEN-HEADEREND:event_ans1ActionPerformed
	ans1.setSelected(true);
    }//GEN-LAST:event_ans1ActionPerformed

    private void ans2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ans2ActionPerformed
    {//GEN-HEADEREND:event_ans2ActionPerformed
	ans2.setSelected(true);
    }//GEN-LAST:event_ans2ActionPerformed

    private void ans3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ans3ActionPerformed
    {//GEN-HEADEREND:event_ans3ActionPerformed
	ans3.setSelected(true);
    }//GEN-LAST:event_ans3ActionPerformed

    private void ans4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ans4ActionPerformed
    {//GEN-HEADEREND:event_ans4ActionPerformed
	ans4.setSelected(true);
    }//GEN-LAST:event_ans4ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[])
	{
		/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try
		{
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
        //</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new MainMenu().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LanguageLbl;
    private javax.swing.JRadioButton ans1;
    private javax.swing.JRadioButton ans2;
    private javax.swing.JRadioButton ans3;
    private javax.swing.JRadioButton ans4;
    private javax.swing.ButtonGroup ansButtonGroup;
    private javax.swing.JPanel answerPanel;
    private javax.swing.JLabel dtLbl;
    private javax.swing.JRadioButton dutLcl;
    private javax.swing.JRadioButton engLcl;
    private javax.swing.JRadioButton finLcl;
    private javax.swing.JLabel imgLbl;
    private javax.swing.JPanel lPanel;
    private javax.swing.JPanel leaderboardPanel;
    private javax.swing.ButtonGroup localeButtonGroup;
    private javax.swing.JLabel qPromptLbl;
    private javax.swing.JPanel questionPanel;
    private javax.swing.JPanel quizPanel;
    private javax.swing.JButton submitBtn;
    private javax.swing.JRadioButton sweLcl;
    // End of variables declaration//GEN-END:variables
	
	private ArrayList<RSAImages> getAllImages(File directory, boolean subDirectory) throws IOException
	{
		ArrayList<RSAImages> resultList = new ArrayList<>();

		File[] f = directory.listFiles();

		for (File file : f)
		{
			RSAImages image = new RSAImages();
			image.setCategory(directory.getName());
			image.setPath(file.getCanonicalPath());
			image.setImageName(file.getName());
			resultList.add(image);

			if (subDirectory && file.isDirectory())
			{
				ArrayList<RSAImages> tmp = getAllImages(file, true);
				if (tmp != null)
					resultList.addAll(tmp);
			}
		}
		
		for (int i = 0; i < resultList.size(); i++) //Remove Folder paths from List
		{
			if (!resultList.get(i).getImageName().endsWith(".gif"))
				resultList.remove(i);
		}
		
		if (resultList.size() > 0)
			return resultList;
		return null;
	}

	private List<Question> generateQuestionObject(Path p)
	{
		List<Question> resultList = new ArrayList<>();
		List<String> questions = new ArrayList<>();
		try
		{
			questions = Files.readAllLines(p); //Get Question Lines
		} catch(IOException i){System.out.println(i);}		
		
			for(String qLine : questions)
			{
				Question q = new Question();
				String parts[] = qLine.split(","); //Get the line, split at delimeter		
				q.setAnswer(parts[0]); //Set first part as question objects Answer
				q.setIncorrectAns1(parts[1]); //Set second part as question objects 1st incorrect answer
				q.setIncorrectAns2(parts[2]); //Set third part as question objects 2nd incorrect answer
				q.setIncorrectAns3(parts[3]); //Set final part as question objects 3rd incorrect answer
				
				resultList.add(q);
			}
			return resultList;
	}

	private void updateStrings(List<Question> qList, List<JRadioButton> buttons)
	{
		rb = ResourceBundle.getBundle("bundles.rb", locale);
		LanguageLbl.setText(rb.getString("Language_Label"));
		engLcl.setText(rb.getString("English_Lang"));
		finLcl.setText(rb.getString("Finnish_Lang"));
		dutLcl.setText(rb.getString("Dutch_Lang"));
		sweLcl.setText(rb.getString("Swedish_Lang"));
		qPromptLbl.setText(rb.getString("Q_Prompt"));
		submitBtn.setText(rb.getString("Submit_Btn"));
		setTitle(rb.getString("Title"));
		
		buttons.get(0).setText(qList.get(count).getAnswer()); //Set text to correct answer
		buttons.get(0).setActionCommand(qList.get(count).getAnswer()); //Set ActionCommand to correct answer (for comparisons - line 639)
			
		buttons.get(1).setText(qList.get(count).getIncorrectAns1()); //Set text to first incorrect answer
		buttons.get(1).setActionCommand(qList.get(count).getIncorrectAns1()); //Set ActionCommand to first incorrect answer
			
		buttons.get(2).setText(qList.get(count).getIncorrectAns2()); //Set text to second incorrect answer
		buttons.get(2).setActionCommand(qList.get(count).getIncorrectAns2()); //Set ActionCommand to second incorrect answer
			
		buttons.get(3).setText(qList.get(count).getIncorrectAns3()); //Set text to third incorrect answer
		buttons.get(3).setActionCommand(qList.get(count).getIncorrectAns3()); //Set ActionCommand to third incorrect answer
		
		//Debug - Console out correct answer to be selected
		System.out.println("Correct Answer Is: "+qList.get(count).getAnswer());
	}

	private void next(List<Question> qList, List<JRadioButton> buttons)
	{	
		if(attempt < maxQuestions) //While maxQuestions have not been attempted [Change maxQuestions to number of questions-1 to be attempted]
		{
			//If actionCommand of selected button matches questionObjects correctAnswer
			if(ansButtonGroup.getSelection().getActionCommand().equals(qList.get(count).getAnswer()))
				correct++;
			
			//For Code Flow Debugging
			System.out.println(String.format("Count: %d, Attempt: %d, Correct: %d", count, attempt, correct));
//			System.out.println("Selected Answer: "+ansButtonGroup.getSelection().getActionCommand()+"\n");
			
			count++; //Increment general counter
			attempt++; //Increment attempt counter
			ansButtonGroup.clearSelection(); //Clear Selection for next round
		
			Collections.shuffle(buttons); //Shuffle buttons around for randomization
			
			buttons.get(0).setText(qList.get(count).getAnswer()); //Set text to correct answer
			buttons.get(0).setActionCommand(qList.get(count).getAnswer()); //Set ActionCommand to correct answer (for comparisons - line 639)
			
			buttons.get(1).setText(qList.get(count).getIncorrectAns1()); //Set text to first incorrect answer
			buttons.get(1).setActionCommand(qList.get(count).getIncorrectAns1()); //Set ActionCommand to first incorrect answer
			
			buttons.get(2).setText(qList.get(count).getIncorrectAns2()); //Set text to second incorrect answer
			buttons.get(2).setActionCommand(qList.get(count).getIncorrectAns2()); //Set ActionCommand to second incorrect answer
			
			buttons.get(3).setText(qList.get(count).getIncorrectAns3()); //Set text to third incorrect answer
			buttons.get(3).setActionCommand(qList.get(count).getIncorrectAns3()); //Set ActionCommand to third incorrect answer
		
			//Debug - Console out correct answer to be selected
			System.out.println("Correct Answer Is: "+qList.get(count).getAnswer());
		
			String imageP = imgList.get(count).getPath(); //Get image path
			imgLbl.setIcon(new ImageIcon(imageP)); //Convert to icon and display on JLabel
		}
		else //Empty GUI and display users results
		{
			qPromptLbl.setText("");
			submitBtn.setEnabled(false);
			imgLbl.setIcon(null);
			for(JRadioButton button : buttons)
			{
				button.setText("");
				button.setEnabled(false);
			}
			if (correct >= (10/2))
			{
				imgLbl.setText(String.format("You Have Passed! You Scored: %d / %d Questions Correct!", correct, attempt));
			}
			else if(correct < (10/2))
			{
				imgLbl.setText(String.format("Sorry, You Have Not Passed, You Scored: %d / %d Questions Correct", correct, attempt));
			}
		}
	}
}
