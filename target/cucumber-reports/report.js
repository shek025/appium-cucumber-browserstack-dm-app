$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/DownloadNewsPaper.feature");
formatter.feature({
  "name": "Launch the app and download given Newspapser edition and Read though it.",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Scenario 1: Verify the Newspaper edition is downloadable.",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@End2End"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User launched Mail+ application",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.launchApp()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "On Newspaper tab, scroll down to Recent issues and scroll right and tap on \u0027SEE MORE\u0027 button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.openRecentIssue(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "On Archive tab, tap to download Sept \"24\" edition",
  "keyword": "And "
});
formatter.match({
  "location": "steps.download(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "On the paywall carousel, sign with credential provided",
  "keyword": "And "
});
formatter.match({
  "location": "steps.on_the_paywall_carousel_sign_with_credential_provided()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Wait for the edition to download completed",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.verifyDownload()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Scenario 2: Verify the Images on Gallery section.",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is On the downloaded Sept 24 edition",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.user_is_On_the_downloaded_Sept_edition(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to Page \"13\" on PDF view that displays \"Every One\u0027s Talking about \" story (Page 13)",
  "keyword": "When "
});
formatter.match({
  "location": "steps.navigate_to_Page_on_PDF_view_that_displays_story_Page(String,String,Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Tap on the Image Gallery is displayed on top of the page",
  "keyword": "And "
});
formatter.match({
  "location": "steps.tap_on_the_Image_Gallery_is_displayed_on_top_of_the_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Now tap on camera icon to open full screen and traverse through all gallery images",
  "keyword": "And "
});
formatter.match({
  "location": "steps.now_tap_on_camera_icon_to_open_full_screen_and_traverse_through_all_gallery_images()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "On last image close the image by clicking on Close button to return to ALB (Article Light Box)",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.on_last_image_close_the_image_by_clicking_on_Close_button_to_return_to_ALB_Article_Light_Box()"
});
formatter.result({
  "status": "passed"
});
});