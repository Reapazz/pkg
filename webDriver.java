package pkg;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

//import com.sun.tools.javac.util.Options;

import java.awt.SystemTray;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Timer;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chromium.*;
import org.openqa.selenium.edge.EdgeOptions;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class webDriver {

	public static WebElement audioButton = null;
	public static FirefoxDriver Selenium2, Selenium, Selenium3, Selenium4, Selenium5, Selenium6;
	public int watchListCounter = 0;
	public String email;
	public boolean exited = false;

	public int botStart = 1;
	public List<String> chatGroups1, chatGroups2, slowModeGroups;
	public String message1 = null, message2 = null, timestamp = null;

	public static FirefoxOptions options = new FirefoxOptions();
	// public static FirefoxProfile profile,profile2,profile3,profile4, profile5,
	// profile6;

	//public static File file = new File("./profiles2/Profile1"); // Ehlers
	//public static File file2 = new File("./profiles2/Profile2");// Elise Sierra
	public static File file1 = new File("./profiles2/Profile3");// Riaz Sawyer
	public static File file2 = new File("./profiles2/Profile4");// FrederickVelez
	public static File file3 = new File("./profiles2/Profile5");// Eleni Hansen
	public static File file4 = new File("./profiles2/Profile6");// Abdu Rohamn
	public static File file5 = new File("./profiles2/Profile7");// A E
//	//public static File file5 = new File("./profiles/Profile5");
//	public static File file6 = new File("./profiles/Profile6");
//	public static File file5 = new File("./profiles/Profile5"); //Darien Clegg
//	//public static File file7 = new File("./profiles/Profile7");// Arlyene Phillie
//	public static File file8 = new File("./profiles/Profile8");// Emmanuel Dougherty
//	public static File file9 = new File("./profiles/Profile9");// Cecil Porter
//	
//	//public static FirefoxProfile profile = new FirefoxProfile(file7);

//	public static FirefoxProfile profile4 = new FirefoxProfile(file4);
//	public static FirefoxProfile profile5 = new FirefoxProfile(file);
//	public static FirefoxProfile profile6 = new FirefoxProfile(file5);
//	public static FirefoxProfile profile7 = new FirefoxProfile(file6);
//	public static FirefoxProfile profile8 = new FirefoxProfile(file2);
//	public static FirefoxProfile profile9 = new FirefoxProfile(file9);
	public static FirefoxProfile profile = new FirefoxProfile(file1);
	public static FirefoxProfile profile2 = new FirefoxProfile(file2);
	public static FirefoxProfile profile3 = new FirefoxProfile(file3);
	public static FirefoxProfile profile4 = new FirefoxProfile(file4);
	public static FirefoxProfile profile5 = new FirefoxProfile(file5);

	
	public int waitTime;
	public static String currentProfile;
	public static int botCounter = 3;
	public static int noChangeProfiles = 0;
	public String profileError = null;
	
	public webDriver(String messageTimestamp, int wait) {
	
		timestamp = messageTimestamp;
		waitTime = wait;
	}

	public void run() throws InterruptedException, IOException {
		sendMsg();

		// testFile();
	}

	public void sendMsg() throws InterruptedException, IOException {
		String chatString = null;
		// options.setProfile(profile2);
		chooseProfile();
		FirefoxDriver SeleniumBot = null;
		SeleniumBot = new FirefoxDriver(options);
		WebElement chatElement = null;

		SeleniumBot.manage().window().maximize();
		TimeUnit.MILLISECONDS.sleep(3000);
		// Selenium2.manage().window().maximize();

		SeleniumBot.get("https://webk.telegram.org");

		Selenium = SeleniumBot;

		TimeUnit.MILLISECONDS.sleep(1500);
		Actions actions = new Actions(SeleniumBot);
		JavascriptExecutor jse = (JavascriptExecutor) SeleniumBot;
	
		while (true) {
			
			if (noChangeProfiles > 5) {
				profileError = currentProfile;
				
				driver.counterTabs
				.setText("Total Shills: " + driver.shillCounter + "    Profile: " +
		webDriver.currentProfile + "   Profile Error: "+ profileError);
				
				chooseProfile();
				
				//chooseProfile();
				SeleniumBot.quit();
				SeleniumBot = new FirefoxDriver(options);
				

				SeleniumBot.manage().window().maximize();
				TimeUnit.MILLISECONDS.sleep(3000);
				// Selenium2.manage().window().maximize();

				SeleniumBot.get("https://webk.telegram.org");
				
				Selenium = SeleniumBot;

				TimeUnit.MILLISECONDS.sleep(1500);
				actions = new Actions(SeleniumBot);
				
				
				TimeUnit.SECONDS.sleep(40);
				
			}
			
			noChangeProfiles++;
			
			
			boolean recentError = false;
			boolean success = false;
			int scrollCounter = 0;
			int chatNumber = 1;
			SeleniumBot.get("https://webk.telegram.org");

			TimeUnit.MILLISECONDS.sleep(1500);

			int errorcounter = 0;
			try {

				// options.setHeadless(true);
				SeleniumBot.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/input"))
						.sendKeys("Uni");
				TimeUnit.MILLISECONDS.sleep(350);
				SeleniumBot.findElement(By.xpath(
						"/html/body/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[1]/ul/li"))
						.click();

				TimeUnit.MILLISECONDS.sleep(1000);

				SeleniumBot.findElement(By.className("chat-info")).click();

				TimeUnit.MILLISECONDS.sleep(2000);

				
				File file = new File("./chatListLog.txt");
				boolean inList = false;
				while (true) {
					@SuppressWarnings("resource")
				
					Scanner scanner = new Scanner(file);

					try {
						chatElement = SeleniumBot.findElement(By.xpath(
								"/html/body/div[2]/div[1]/div[3]/div/div/div[2]/div/div/div[4]/div[2]/div[1]/div/ul/li["
										+ chatNumber + "]"));

						while (scanner.hasNextLine()) {
							String line = scanner.nextLine();
								System.out.println("Scanner line: "+ line);
							if (line.equals(chatElement.getAttribute("data-peer-id"))) {
								System.out.println("Chat Already in list");
								chatNumber++;

								inList = true;
								break;

							}

						}
						if (inList == true) {
							inList = false;
							TimeUnit.MILLISECONDS.sleep(500);
							continue;

						}

						TimeUnit.MILLISECONDS.sleep(500);
						break;

					} catch (Exception errorFindingChat) {
						System.out.println("error finding chat");
						errorFindingChat.printStackTrace();
						recentError = true;
						break;
					}

				}

				if (recentError == true) {
					recentError = false;
					continue;
				}

				chatString = chatElement.getAttribute("data-peer-id");
				System.out.println("Found chat not in list: " + chatString);

			}

			catch (Exception E) {
				System.out.println("error 3");
				E.printStackTrace();
				continue;
			}

			while (scrollCounter < 50) {

				scrollCounter++;
				try {
					chatElement.click();
					break;
				}

				catch (Exception scrollError) {
					TimeUnit.MILLISECONDS.sleep(400);

					try {
						WebElement scroller = SeleniumBot
								.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div/div/div[2]/div"));

						scroller.sendKeys(Keys.PAGE_DOWN);
					}

					catch (Error scrollerFindError) {
						scrollerFindError.printStackTrace();
						break;

					}
					TimeUnit.MILLISECONDS.sleep(400);
					
					continue;
				}
			}

			try {
				TimeUnit.MILLISECONDS.sleep(2000);
				SeleniumBot
						.findElement(By.xpath(
								"/html/body/div[2]/div[1]/div[2]/div/div[2]/div[4]/div/div[1]/div[7]/div[1]/div[1]"))
						.sendKeys("Hi there! Here is a quick message please take a look if you have the time");

				SeleniumBot.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div[2]/div[4]/div/div[4]/button"))
						.click();

				TimeUnit.MILLISECONDS.sleep(500);

				int tryForwardMsgCounter = 0;
				while (tryForwardMsgCounter < 3) {
					
					tryForwardMsgCounter++;
					SeleniumBot.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/input"))
							.sendKeys("tatabot");
					TimeUnit.MILLISECONDS.sleep(350);
					SeleniumBot.findElement(By.xpath(
							"/html/body/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[1]/ul/li"))
							.click();

					TimeUnit.MILLISECONDS.sleep(1000);

					// TimeUnit.MILLISECONDS.sleep(1000);
					WebElement pinnedButton = SeleniumBot
							.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]"));

					pinnedButton.click();

					TimeUnit.MILLISECONDS.sleep(1500);

					List<WebElement> forwardedMessages = SeleniumBot
							.findElements(By.cssSelector("div[data-timestamp='" + timestamp + "']"));

					WebElement mascotPicture = forwardedMessages.get(0);
					WebElement appPicture = forwardedMessages.get(2);
					WebElement messageZee = forwardedMessages.get(1);

					actions.moveToElement(appPicture);
					actions.contextClick(appPicture).build().perform();
					TimeUnit.MILLISECONDS.sleep(1200);

					WebElement buttonPane = SeleniumBot.findElement(By.className("contextmenu"));
					WebElement selectButton = buttonPane

							.findElement(By.className("tgico-select"));

					TimeUnit.MILLISECONDS.sleep(500);

					selectButton.click();

					TimeUnit.MILLISECONDS.sleep(500);
					actions.moveToElement(messageZee);
					actions.click(messageZee).build().perform();
					TimeUnit.MILLISECONDS.sleep(500);

					pinnedButton.click();

					TimeUnit.MILLISECONDS.sleep(800);

					actions.moveToElement(mascotPicture);
					actions.click(mascotPicture).build().perform();
					TimeUnit.MILLISECONDS.sleep(500);

					WebElement forwardButton = SeleniumBot.findElement(By.className("selection-container-forward"));
					// By.xpath("//div[@id='column-center']/div/div/div[4]/div/div[5]/div/button[2]/div"));
					actions.moveToElement(forwardButton);
					actions.click(forwardButton).build().perform();
					TimeUnit.MILLISECONDS.sleep(500);

					WebElement selector = SeleniumBot.findElement(By.className("selector"));
					WebElement scroller1 = selector.findElement(By.className("scrollable"));

					int scrollCounter1 = 0;
					while (scrollCounter1 < 5) {
						scrollCounter1++;
						try {
							String groupName = "li[data-peer-id='" + chatString + "']";
							WebElement groupElement = selector.findElement(By.cssSelector(groupName));
							groupElement.click();
							break;
						}

						catch (Exception scrollError) {
							try {
								 
								
								scroller1.sendKeys(Keys.PAGE_DOWN);
							} catch (Exception e2) {
								System.out.println("Error scroll 1");
								e2.printStackTrace();
								
								recentError = true;
								break;
							}
							TimeUnit.MILLISECONDS.sleep(400);
							continue;

						}

					}
					if (recentError == true) {

						recentError = false;
						continue;
					}

					TimeUnit.MILLISECONDS.sleep(500);

					SeleniumBot
							.findElement(
									By.xpath("/html/body/div[2]/div[1]/div[2]/div/div[2]/div[4]/div/div[4]/button"))
							.click();
					System.out.println("Forwarded Message to: " + chatString);
					success = true;
					break;
				}
				if (success = true) {
					success  = false;
				FileWriter writer = new FileWriter("chatListLog.txt", true);

				writer.write("\r\n");
				writer.write(chatString);
				writer.close();

				driver.shillCounter++;
				driver.counterTabs
						.setText("Total Shills: " + driver.shillCounter + "    Profile: " +
				webDriver.currentProfile + "   Profile Error: "+ profileError);

				chooseProfile();
				SeleniumBot.quit();
				SeleniumBot = new FirefoxDriver(options);
				

				SeleniumBot.manage().window().maximize();
				TimeUnit.MILLISECONDS.sleep(3000);
				// Selenium2.manage().window().maximize();

				SeleniumBot.get("https://webk.telegram.org");
				
				Selenium = SeleniumBot;

				TimeUnit.MILLISECONDS.sleep(1500);
				actions = new Actions(SeleniumBot);
				
				
				TimeUnit.SECONDS.sleep(40);
				}

			}

			catch (Exception e3) {
				e3.printStackTrace();
				continue;
			}

		}

	}

	public static void chooseProfile() {
		noChangeProfiles = 0;
		if (botCounter == 1) {
			botCounter++;
			options.setProfile(profile);
			currentProfile = "Profile1";
			// SeleniumBot = new FirefoxDriver(options);
			// Selenium2 = new FirefoxDriver(options);

		} else if (botCounter == 2) {
			botCounter++;
			options.setProfile(profile2);
			currentProfile = "Profile2";
			// SeleniumBot = new FirefoxDriver(options);
			// Selenium2 = new FirefoxDriver(options);
		} else if (botCounter == 3) {
			botCounter ++;
			options.setProfile(profile3);
			currentProfile = "Profile3";
			// SeleniumBot = new FirefoxDriver(options);
			// Selenium2 = new FirefoxDriver(options);
		}
		 else if (botCounter == 4) {
			botCounter++;
			options.setProfile(profile4);
			currentProfile = "Profile4"; 
		
		//Selenium2 = new FirefoxDriver(options);
		}
		
		else if (botCounter == 5) {
			botCounter = 1;
			options.setProfile(profile5);
			currentProfile = "Profile5"; 
		
		//Selenium2 = new FirefoxDriver(options);
		}
//		else if (botCounter == 6) {
//			botCounter ++;
//			options.setProfile(profile6);
//			currentProfile = "Profile"; 
//		
//		//Selenium2 = new FirefoxDriver(options);
//		}
//		else if (botCounter == 7) {
//			botCounter =1;
//			options.setProfile(profile7);
//			currentProfile = "Profile7"; 
//		
//		//Selenium2 = new FirefoxDriver(options);
//		}

		System.out.println("testprofile");
	}

	public void testFile() throws InterruptedException, IOException {

		FileWriter writer = new FileWriter("chatListLog.txt", true);

		writer.write('\n');
		writer.append("\n");
		writer.write("test");

		writer.write("\n");
		writer.append("\n");
		writer.write("test2");

		writer.write("\r\n");
		writer.write("test3");

		writer.close();

	}

	public void closeTabs() {
		try {
			// Selenium.close();
			// Selenium2.close();

			// Selenium3.quit();
			// Selenium2.quit();
			Selenium.quit();
			// Selenium.quit();
		} catch (Exception error2) {
		}

	}

}
