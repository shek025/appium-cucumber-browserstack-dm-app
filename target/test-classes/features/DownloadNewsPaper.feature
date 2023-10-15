Feature: Launch the app and download given Newspapser edition and Read though it.

  @End2End
  Scenario: Scenario 1: Verify the Newspaper edition is downloadable. 
    Given User launched Mail+ application
		When On Newspaper tab, scroll down to Recent issues and scroll right and tap on 'SEE MORE' button
 		And On Archive tab, tap to download Sept "24" edition
		And On the paywall carousel, sign with credential provided
		Then Wait for the edition to download completed
		
	Scenario: Scenario 2: Verify the Images on Gallery section. 
		Given User is On the downloaded Sept 24 edition
		When Navigate to Page "13" on PDF view that displays "Every One's Talking about " story (Page 13)
		And Tap on the Image Gallery is displayed on top of the page
		And Now tap on camera icon to open full screen and traverse through all gallery images
		Then On last image close the image by clicking on Close button to return to ALB (Article Light Box)	
	
		

