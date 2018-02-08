package cn.com.youngon.util;

import java.util.HashMap;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;

public class FontawesomeWithJavaFX{
	private static final Font GLYPH_FONTAWESOME;
	private static final Map<String, Character> GLYPH_MAP;

	static {
		GLYPH_FONTAWESOME = Font
				.loadFont(FontawesomeWithJavaFX.class.getResourceAsStream("fontawesome-webfont@4.5.0.ttf"), -1);
		GLYPH_MAP = new HashMap<String, Character>();
		GLYPH_MAP.put("fa_500px", '\uf26e');
		GLYPH_MAP.put("adjust", '\uf042');
		GLYPH_MAP.put("adn", '\uf170');
		GLYPH_MAP.put("align_center", '\uf037');
		GLYPH_MAP.put("align_justify", '\uf039');
		GLYPH_MAP.put("align_left", '\uf036');
		GLYPH_MAP.put("align_right", '\uf038');
		GLYPH_MAP.put("amazon", '\uf270');
		GLYPH_MAP.put("ambulance", '\uf0f9');
		GLYPH_MAP.put("anchor", '\uf13d');
		GLYPH_MAP.put("android", '\uf17b');
		GLYPH_MAP.put("angellist", '\uf209');
		GLYPH_MAP.put("angle_double_down", '\uf103');
		GLYPH_MAP.put("angle_double_left", '\uf100');
		GLYPH_MAP.put("angle_double_right", '\uf101');
		GLYPH_MAP.put("angle_double_up", '\uf102');
		GLYPH_MAP.put("angle_down", '\uf107');
		GLYPH_MAP.put("angle_left", '\uf104');
		GLYPH_MAP.put("angle_right", '\uf105');
		GLYPH_MAP.put("angle_up", '\uf106');
		GLYPH_MAP.put("apple", '\uf179');
		GLYPH_MAP.put("archive", '\uf187');
		GLYPH_MAP.put("area_chart", '\uf1fe');
		GLYPH_MAP.put("arrow_circle_down", '\uf0ab');
		GLYPH_MAP.put("arrow_circle_left", '\uf0a8');
		GLYPH_MAP.put("arrow_circle_alt_down", '\uf01a');
		GLYPH_MAP.put("arrow_circle_alt_left", '\uf190');
		GLYPH_MAP.put("arrow_circle_alt_right", '\uf18e');
		GLYPH_MAP.put("arrow_circle_alt_up", '\uf01b');
		GLYPH_MAP.put("arrow_circle_right", '\uf0a9');
		GLYPH_MAP.put("arrow_circle_up", '\uf0aa');
		GLYPH_MAP.put("arrow_down", '\uf063');
		GLYPH_MAP.put("arrow_left", '\uf060');
		GLYPH_MAP.put("arrow_right", '\uf061');
		GLYPH_MAP.put("arrow_up", '\uf062');
		GLYPH_MAP.put("arrows", '\uf047');
		GLYPH_MAP.put("arrows_alt", '\uf0b2');
		GLYPH_MAP.put("arrows_h", '\uf07e');
		GLYPH_MAP.put("arrows_v", '\uf07d');
		GLYPH_MAP.put("asterisk", '\uf069');
		GLYPH_MAP.put("at", '\uf1fa');
		GLYPH_MAP.put("automobile", '\uf1b9');
		GLYPH_MAP.put("backward", '\uf04a');
		GLYPH_MAP.put("balance_scale", '\uf24e');
		GLYPH_MAP.put("ban", '\uf05e');
		GLYPH_MAP.put("bank", '\uf19c');
		GLYPH_MAP.put("bar_chart", '\uf080');
		GLYPH_MAP.put("bar_chart_alt", '\uf080');
		GLYPH_MAP.put("barcode", '\uf02a');
		GLYPH_MAP.put("bars", '\uf0c9');
		GLYPH_MAP.put("battery_0", '\uf244');
		GLYPH_MAP.put("battery_1", '\uf243');
		GLYPH_MAP.put("battery_2", '\uf242');
		GLYPH_MAP.put("battery_3", '\uf241');
		GLYPH_MAP.put("battery_4", '\uf240');
		GLYPH_MAP.put("battery_empty", '\uf244');
		GLYPH_MAP.put("battery_full", '\uf240');
		GLYPH_MAP.put("battery_half", '\uf242');
		GLYPH_MAP.put("battery_quarter", '\uf243');
		GLYPH_MAP.put("battery_three_quarters", '\uf241');
		GLYPH_MAP.put("bed", '\uf236');
		GLYPH_MAP.put("beer", '\uf0fc');
		GLYPH_MAP.put("behance", '\uf1b4');
		GLYPH_MAP.put("behance_square", '\uf1b5');
		GLYPH_MAP.put("bell", '\uf0f3');
		GLYPH_MAP.put("bell_alt", '\uf0a2');
		GLYPH_MAP.put("bell_slash", '\uf1f6');
		GLYPH_MAP.put("bell_slash_alt", '\uf1f7');
		GLYPH_MAP.put("bicycle", '\uf206');
		GLYPH_MAP.put("binoculars", '\uf1e5');
		GLYPH_MAP.put("birthday_cake", '\uf1fd');
		GLYPH_MAP.put("bitbucket", '\uf171');
		GLYPH_MAP.put("bitbucket_square", '\uf172');
		GLYPH_MAP.put("bitcoin", '\uf15a');
		GLYPH_MAP.put("black_tie", '\uf27e');
		GLYPH_MAP.put("bluetooth", '\uf293');
		GLYPH_MAP.put("bluetooth_b", '\uf294');
		GLYPH_MAP.put("bold", '\uf032');
		GLYPH_MAP.put("bolt", '\uf0e7');
		GLYPH_MAP.put("bomb", '\uf1e2');
		GLYPH_MAP.put("book", '\uf02d');
		GLYPH_MAP.put("bookmark", '\uf02e');
		GLYPH_MAP.put("bookmark_alt", '\uf097');
		GLYPH_MAP.put("briefcase", '\uf0b1');
		GLYPH_MAP.put("btc", '\uf15a');
		GLYPH_MAP.put("bug", '\uf188');
		GLYPH_MAP.put("building", '\uf1ad');
		GLYPH_MAP.put("building_alt", '\uf0f7');
		GLYPH_MAP.put("bullhorn", '\uf0a1');
		GLYPH_MAP.put("bullseye", '\uf140');
		GLYPH_MAP.put("bus", '\uf207');
		GLYPH_MAP.put("buysellads", '\uf20d');
		GLYPH_MAP.put("cab", '\uf1ba');
		GLYPH_MAP.put("calculator", '\uf1ec');
		GLYPH_MAP.put("calendar", '\uf073');
		GLYPH_MAP.put("calendar_check_alt", '\uf274');
		GLYPH_MAP.put("calendar_minus_alt", '\uf272');
		GLYPH_MAP.put("calendar_alt", '\uf133');
		GLYPH_MAP.put("calendar_plus_alt", '\uf271');
		GLYPH_MAP.put("calendar_times_alt", '\uf273');
		GLYPH_MAP.put("camera", '\uf030');
		GLYPH_MAP.put("camera_retro", '\uf083');
		GLYPH_MAP.put("car", '\uf1b9');
		GLYPH_MAP.put("caret_down", '\uf0d7');
		GLYPH_MAP.put("caret_left", '\uf0d9');
		GLYPH_MAP.put("caret_right", '\uf0da');
		GLYPH_MAP.put("caret_square_alt_down", '\uf150');
		GLYPH_MAP.put("caret_square_alt_left", '\uf191');
		GLYPH_MAP.put("caret_square_alt_right", '\uf152');
		GLYPH_MAP.put("caret_square_alt_up", '\uf151');
		GLYPH_MAP.put("caret_up", '\uf0d8');
		GLYPH_MAP.put("cart_arrow_down", '\uf218');
		GLYPH_MAP.put("cart_plus", '\uf217');
		GLYPH_MAP.put("cc", '\uf20a');
		GLYPH_MAP.put("cc_amex", '\uf1f3');
		GLYPH_MAP.put("cc_diners_club", '\uf24c');
		GLYPH_MAP.put("cc_discover", '\uf1f2');
		GLYPH_MAP.put("cc_jcb", '\uf24b');
		GLYPH_MAP.put("cc_mastercard", '\uf1f1');
		GLYPH_MAP.put("cc_paypal", '\uf1f4');
		GLYPH_MAP.put("cc_stripe", '\uf1f5');
		GLYPH_MAP.put("cc_visa", '\uf1f0');
		GLYPH_MAP.put("certificate", '\uf0a3');
		GLYPH_MAP.put("chain", '\uf0c1');
		GLYPH_MAP.put("chain_broken", '\uf127');
		GLYPH_MAP.put("check", '\uf00c');
		GLYPH_MAP.put("check_circle", '\uf058');
		GLYPH_MAP.put("check_circle_alt", '\uf05d');
		GLYPH_MAP.put("check_square", '\uf14a');
		GLYPH_MAP.put("check_square_alt", '\uf046');
		GLYPH_MAP.put("chevron_circle_down", '\uf13a');
		GLYPH_MAP.put("chevron_circle_left", '\uf137');
		GLYPH_MAP.put("chevron_circle_right", '\uf138');
		GLYPH_MAP.put("chevron_circle_up", '\uf139');
		GLYPH_MAP.put("chevron_down", '\uf078');
		GLYPH_MAP.put("chevron_left", '\uf053');
		GLYPH_MAP.put("chevron_right", '\uf054');
		GLYPH_MAP.put("chevron_up", '\uf077');
		GLYPH_MAP.put("child", '\uf1ae');
		GLYPH_MAP.put("chrome", '\uf268');
		GLYPH_MAP.put("circle", '\uf111');
		GLYPH_MAP.put("circle_alt", '\uf10c');
		GLYPH_MAP.put("circle_alt_notch", '\uf1ce');
		GLYPH_MAP.put("circle_thin", '\uf1db');
		GLYPH_MAP.put("clipboard", '\uf0ea');
		GLYPH_MAP.put("clock_alt", '\uf017');
		GLYPH_MAP.put("clone", '\uf24d');
		GLYPH_MAP.put("close", '\uf00d');
		GLYPH_MAP.put("cloud", '\uf0c2');
		GLYPH_MAP.put("cloud_download", '\uf0ed');
		GLYPH_MAP.put("cloud_upload", '\uf0ee');
		GLYPH_MAP.put("cny", '\uf157');
		GLYPH_MAP.put("code", '\uf121');
		GLYPH_MAP.put("code_fork", '\uf126');
		GLYPH_MAP.put("codepen", '\uf1cb');
		GLYPH_MAP.put("codiepie", '\uf284');
		GLYPH_MAP.put("coffee", '\uf0f4');
		GLYPH_MAP.put("cog", '\uf013');
		GLYPH_MAP.put("cogs", '\uf085');
		GLYPH_MAP.put("columns", '\uf0db');
		GLYPH_MAP.put("comment", '\uf075');
		GLYPH_MAP.put("comment_alt", '\uf0e5');
		GLYPH_MAP.put("commenting", '\uf27a');
		GLYPH_MAP.put("commenting_alt", '\uf27b');
		GLYPH_MAP.put("comments", '\uf086');
		GLYPH_MAP.put("comments_alt", '\uf0e6');
		GLYPH_MAP.put("compass", '\uf14e');
		GLYPH_MAP.put("compress", '\uf066');
		GLYPH_MAP.put("connectdevelop", '\uf20e');
		GLYPH_MAP.put("contao", '\uf26d');
		GLYPH_MAP.put("copy", '\uf0c5');
		GLYPH_MAP.put("copyright", '\uf1f9');
		GLYPH_MAP.put("creative_commons", '\uf25e');
		GLYPH_MAP.put("credit_card", '\uf09d');
		GLYPH_MAP.put("credit_card_alt", '\uf283');
		GLYPH_MAP.put("crop", '\uf125');
		GLYPH_MAP.put("crosshairs", '\uf05b');
		GLYPH_MAP.put("css3", '\uf13c');
		GLYPH_MAP.put("cube", '\uf1b2');
		GLYPH_MAP.put("cubes", '\uf1b3');
		GLYPH_MAP.put("cut", '\uf0c4');
		GLYPH_MAP.put("cutlery", '\uf0f5');
		GLYPH_MAP.put("dashboard", '\uf0e4');
		GLYPH_MAP.put("dashcube", '\uf210');
		GLYPH_MAP.put("database", '\uf1c0');
		GLYPH_MAP.put("dedent", '\uf03b');
		GLYPH_MAP.put("delicious", '\uf1a5');
		GLYPH_MAP.put("desktop", '\uf108');
		GLYPH_MAP.put("deviantart", '\uf1bd');
		GLYPH_MAP.put("diamond", '\uf219');
		GLYPH_MAP.put("digg", '\uf1a6');
		GLYPH_MAP.put("dollar", '\uf155');
		GLYPH_MAP.put("dot_circle_alt", '\uf192');
		GLYPH_MAP.put("download", '\uf019');
		GLYPH_MAP.put("dribbble", '\uf17d');
		GLYPH_MAP.put("dropbox", '\uf16b');
		GLYPH_MAP.put("drupal", '\uf1a9');
		GLYPH_MAP.put("edge", '\uf282');
		GLYPH_MAP.put("edit", '\uf044');
		GLYPH_MAP.put("eject", '\uf052');
		GLYPH_MAP.put("ellipsis_h", '\uf141');
		GLYPH_MAP.put("ellipsis_v", '\uf142');
		GLYPH_MAP.put("empire", '\uf1d1');
		GLYPH_MAP.put("envelope", '\uf0e0');
		GLYPH_MAP.put("envelope_alt", '\uf003');
		GLYPH_MAP.put("envelope_square", '\uf199');
		GLYPH_MAP.put("eraser", '\uf12d');
		GLYPH_MAP.put("eur", '\uf153');
		GLYPH_MAP.put("euro", '\uf153');
		GLYPH_MAP.put("exchange", '\uf0ec');
		GLYPH_MAP.put("exclamation", '\uf12a');
		GLYPH_MAP.put("exclamation_circle", '\uf06a');
		GLYPH_MAP.put("exclamation_triangle", '\uf071');
		GLYPH_MAP.put("expand", '\uf065');
		GLYPH_MAP.put("expeditedssl", '\uf23e');
		GLYPH_MAP.put("external_link", '\uf08e');
		GLYPH_MAP.put("external_link_square", '\uf14c');
		GLYPH_MAP.put("eye", '\uf06e');
		GLYPH_MAP.put("eye_slash", '\uf070');
		GLYPH_MAP.put("eyedropper", '\uf1fb');
		GLYPH_MAP.put("facebook", '\uf09a');
		GLYPH_MAP.put("facebook_f", '\uf09a');
		GLYPH_MAP.put("facebook_official", '\uf230');
		GLYPH_MAP.put("facebook_square", '\uf082');
		GLYPH_MAP.put("fast_backward", '\uf049');
		GLYPH_MAP.put("fast_forward", '\uf050');
		GLYPH_MAP.put("fax", '\uf1ac');
		GLYPH_MAP.put("feed", '\uf09e');
		GLYPH_MAP.put("female", '\uf182');
		GLYPH_MAP.put("fighter_jet", '\uf0fb');
		GLYPH_MAP.put("file", '\uf15b');
		GLYPH_MAP.put("file_archive_alt", '\uf1c6');
		GLYPH_MAP.put("file_audio_alt", '\uf1c7');
		GLYPH_MAP.put("file_code_alt", '\uf1c9');
		GLYPH_MAP.put("file_excel_alt", '\uf1c3');
		GLYPH_MAP.put("file_image_alt", '\uf1c5');
		GLYPH_MAP.put("file_movie_alt", '\uf1c8');
		GLYPH_MAP.put("file_alt", '\uf016');
		GLYPH_MAP.put("file_pdf_alt", '\uf1c1');
		GLYPH_MAP.put("file_photo_alt", '\uf1c5');
		GLYPH_MAP.put("file_picture_alt", '\uf1c5');
		GLYPH_MAP.put("file_powerpoint_alt", '\uf1c4');
		GLYPH_MAP.put("file_sound_alt", '\uf1c7');
		GLYPH_MAP.put("file_text", '\uf15c');
		GLYPH_MAP.put("file_text_alt", '\uf0f6');
		GLYPH_MAP.put("file_video_alt", '\uf1c8');
		GLYPH_MAP.put("file_word_alt", '\uf1c2');
		GLYPH_MAP.put("file_zip_alt", '\uf1c6');
		GLYPH_MAP.put("files_alt", '\uf0c5');
		GLYPH_MAP.put("film", '\uf008');
		GLYPH_MAP.put("filter", '\uf0b0');
		GLYPH_MAP.put("fire", '\uf06d');
		GLYPH_MAP.put("fire_extinguisher", '\uf134');
		GLYPH_MAP.put("firefox", '\uf269');
		GLYPH_MAP.put("flag", '\uf024');
		GLYPH_MAP.put("flag_checkered", '\uf11e');
		GLYPH_MAP.put("flag_alt", '\uf11d');
		GLYPH_MAP.put("flash", '\uf0e7');
		GLYPH_MAP.put("flask", '\uf0c3');
		GLYPH_MAP.put("flickr", '\uf16e');
		GLYPH_MAP.put("floppy_alt", '\uf0c7');
		GLYPH_MAP.put("folder", '\uf07b');
		GLYPH_MAP.put("folder_alt", '\uf114');
		GLYPH_MAP.put("folder_open", '\uf07c');
		GLYPH_MAP.put("folder_open_alt", '\uf115');
		GLYPH_MAP.put("font", '\uf031');
		GLYPH_MAP.put("fonticons", '\uf280');
		GLYPH_MAP.put("fort_awesome", '\uf286');
		GLYPH_MAP.put("forumbee", '\uf211');
		GLYPH_MAP.put("forward", '\uf04e');
		GLYPH_MAP.put("foursquare", '\uf180');
		GLYPH_MAP.put("frown_alt", '\uf119');
		GLYPH_MAP.put("futbol_alt", '\uf1e3');
		GLYPH_MAP.put("gamepad", '\uf11b');
		GLYPH_MAP.put("gavel", '\uf0e3');
		GLYPH_MAP.put("gbp", '\uf154');
		GLYPH_MAP.put("ge", '\uf1d1');
		GLYPH_MAP.put("gear", '\uf013');
		GLYPH_MAP.put("gears", '\uf085');
		GLYPH_MAP.put("genderless", '\uf22d');
		GLYPH_MAP.put("get_pocket", '\uf265');
		GLYPH_MAP.put("gg", '\uf260');
		GLYPH_MAP.put("gg_circle", '\uf261');
		GLYPH_MAP.put("gift", '\uf06b');
		GLYPH_MAP.put("git", '\uf1d3');
		GLYPH_MAP.put("git_square", '\uf1d2');
		GLYPH_MAP.put("github", '\uf09b');
		GLYPH_MAP.put("github_alt", '\uf113');
		GLYPH_MAP.put("github_square", '\uf092');
		GLYPH_MAP.put("gittip", '\uf184');
		GLYPH_MAP.put("glass", '\uf000');
		GLYPH_MAP.put("globe", '\uf0ac');
		GLYPH_MAP.put("google", '\uf1a0');
		GLYPH_MAP.put("google_plus", '\uf0d5');
		GLYPH_MAP.put("google_plus_square", '\uf0d4');
		GLYPH_MAP.put("google_wallet", '\uf1ee');
		GLYPH_MAP.put("graduation_cap", '\uf19d');
		GLYPH_MAP.put("gratipay", '\uf184');
		GLYPH_MAP.put("group", '\uf0c0');
		GLYPH_MAP.put("h_square", '\uf0fd');
		GLYPH_MAP.put("hacker_news", '\uf1d4');
		GLYPH_MAP.put("hand_grab_alt", '\uf255');
		GLYPH_MAP.put("hand_lizard_alt", '\uf258');
		GLYPH_MAP.put("hand_alt_down", '\uf0a7');
		GLYPH_MAP.put("hand_alt_left", '\uf0a5');
		GLYPH_MAP.put("hand_alt_right", '\uf0a4');
		GLYPH_MAP.put("hand_alt_up", '\uf0a6');
		GLYPH_MAP.put("hand_paper_alt", '\uf256');
		GLYPH_MAP.put("hand_peace_alt", '\uf25b');
		GLYPH_MAP.put("hand_pointer_alt", '\uf25a');
		GLYPH_MAP.put("hand_rock_alt", '\uf255');
		GLYPH_MAP.put("hand_scissors_alt", '\uf257');
		GLYPH_MAP.put("hand_spock_alt", '\uf259');
		GLYPH_MAP.put("hand_stop_alt", '\uf256');
		GLYPH_MAP.put("hashtag", '\uf292');
		GLYPH_MAP.put("hdd_alt", '\uf0a0');
		GLYPH_MAP.put("header", '\uf1dc');
		GLYPH_MAP.put("headphones", '\uf025');
		GLYPH_MAP.put("heart", '\uf004');
		GLYPH_MAP.put("heart_alt", '\uf08a');
		GLYPH_MAP.put("heartbeat", '\uf21e');
		GLYPH_MAP.put("history", '\uf1da');
		GLYPH_MAP.put("home", '\uf015');
		GLYPH_MAP.put("hospital_alt", '\uf0f8');
		GLYPH_MAP.put("hotel", '\uf236');
		GLYPH_MAP.put("hourglass", '\uf254');
		GLYPH_MAP.put("hourglass_1", '\uf250');
		GLYPH_MAP.put("hourglass_2", '\uf252');
		GLYPH_MAP.put("hourglass_3", '\uf253');
		GLYPH_MAP.put("hourglass_end", '\uf253');
		GLYPH_MAP.put("hourglass_half", '\uf252');
		GLYPH_MAP.put("hourglass_alt", '\uf250');
		GLYPH_MAP.put("hourglass_start", '\uf251');
		GLYPH_MAP.put("houzz", '\uf27c');
		GLYPH_MAP.put("html5", '\uf13b');
		GLYPH_MAP.put("i_cursor", '\uf246');
		GLYPH_MAP.put("ils", '\uf20b');
		GLYPH_MAP.put("image", '\uf03e');
		GLYPH_MAP.put("inbox", '\uf01c');
		GLYPH_MAP.put("indent", '\uf03c');
		GLYPH_MAP.put("industry", '\uf275');
		GLYPH_MAP.put("info", '\uf129');
		GLYPH_MAP.put("info_circle", '\uf05a');
		GLYPH_MAP.put("inr", '\uf156');
		GLYPH_MAP.put("instagram", '\uf16d');
		GLYPH_MAP.put("institution", '\uf19c');
		GLYPH_MAP.put("internet_explorer", '\uf26b');
		GLYPH_MAP.put("intersex", '\uf224');
		GLYPH_MAP.put("ioxhost", '\uf208');
		GLYPH_MAP.put("italic", '\uf033');
		GLYPH_MAP.put("joomla", '\uf1aa');
		GLYPH_MAP.put("jpy", '\uf157');
		GLYPH_MAP.put("jsfiddle", '\uf1cc');
		GLYPH_MAP.put("key", '\uf084');
		GLYPH_MAP.put("keyboard_alt", '\uf11c');
		GLYPH_MAP.put("krw", '\uf159');
		GLYPH_MAP.put("language", '\uf1ab');
		GLYPH_MAP.put("laptop", '\uf109');
		GLYPH_MAP.put("lastfm", '\uf202');
		GLYPH_MAP.put("lastfm_square", '\uf203');
		GLYPH_MAP.put("leaf", '\uf06c');
		GLYPH_MAP.put("leanpub", '\uf212');
		GLYPH_MAP.put("legal", '\uf0e3');
		GLYPH_MAP.put("lemon_alt", '\uf094');
		GLYPH_MAP.put("level_down", '\uf149');
		GLYPH_MAP.put("level_up", '\uf148');
		GLYPH_MAP.put("life_bouy", '\uf1cd');
		GLYPH_MAP.put("life_buoy", '\uf1cd');
		GLYPH_MAP.put("life_ring", '\uf1cd');
		GLYPH_MAP.put("life_saver", '\uf1cd');
		GLYPH_MAP.put("lightbulb_alt", '\uf0eb');
		GLYPH_MAP.put("line_chart", '\uf201');
		GLYPH_MAP.put("link", '\uf0c1');
		GLYPH_MAP.put("linkedin", '\uf0e1');
		GLYPH_MAP.put("linkedin_square", '\uf08c');
		GLYPH_MAP.put("linux", '\uf17c');
		GLYPH_MAP.put("list", '\uf03a');
		GLYPH_MAP.put("list_alt", '\uf022');
		GLYPH_MAP.put("list_ol", '\uf0cb');
		GLYPH_MAP.put("list_ul", '\uf0ca');
		GLYPH_MAP.put("location_arrow", '\uf124');
		GLYPH_MAP.put("lock", '\uf023');
		GLYPH_MAP.put("long_arrow_down", '\uf175');
		GLYPH_MAP.put("long_arrow_left", '\uf177');
		GLYPH_MAP.put("long_arrow_right", '\uf178');
		GLYPH_MAP.put("long_arrow_up", '\uf176');
		GLYPH_MAP.put("magic", '\uf0d0');
		GLYPH_MAP.put("magnet", '\uf076');
		GLYPH_MAP.put("mail_forward", '\uf064');
		GLYPH_MAP.put("mail_reply", '\uf112');
		GLYPH_MAP.put("mail_reply_all", '\uf122');
		GLYPH_MAP.put("male", '\uf183');
		GLYPH_MAP.put("GLYPH_MAP", '\uf279');
		GLYPH_MAP.put("map_marker", '\uf041');
		GLYPH_MAP.put("map_alt", '\uf278');
		GLYPH_MAP.put("map_pin", '\uf276');
		GLYPH_MAP.put("map_signs", '\uf277');
		GLYPH_MAP.put("mars", '\uf222');
		GLYPH_MAP.put("mars_double", '\uf227');
		GLYPH_MAP.put("mars_stroke", '\uf229');
		GLYPH_MAP.put("mars_stroke_h", '\uf22b');
		GLYPH_MAP.put("mars_stroke_v", '\uf22a');
		GLYPH_MAP.put("maxcdn", '\uf136');
		GLYPH_MAP.put("meanpath", '\uf20c');
		GLYPH_MAP.put("medium", '\uf23a');
		GLYPH_MAP.put("medkit", '\uf0fa');
		GLYPH_MAP.put("meh_alt", '\uf11a');
		GLYPH_MAP.put("mercury", '\uf223');
		GLYPH_MAP.put("microphone", '\uf130');
		GLYPH_MAP.put("microphone_slash", '\uf131');
		GLYPH_MAP.put("minus", '\uf068');
		GLYPH_MAP.put("minus_circle", '\uf056');
		GLYPH_MAP.put("minus_square", '\uf146');
		GLYPH_MAP.put("minus_square_alt", '\uf147');
		GLYPH_MAP.put("mixcloud", '\uf289');
		GLYPH_MAP.put("mobile", '\uf10b');
		GLYPH_MAP.put("mobile_phone", '\uf10b');
		GLYPH_MAP.put("modx", '\uf285');
		GLYPH_MAP.put("money", '\uf0d6');
		GLYPH_MAP.put("moon_alt", '\uf186');
		GLYPH_MAP.put("mortar_board", '\uf19d');
		GLYPH_MAP.put("motorcycle", '\uf21c');
		GLYPH_MAP.put("mouse_pointer", '\uf245');
		GLYPH_MAP.put("music", '\uf001');
		GLYPH_MAP.put("navicon", '\uf0c9');
		GLYPH_MAP.put("neuter", '\uf22c');
		GLYPH_MAP.put("newspaper_alt", '\uf1ea');
		GLYPH_MAP.put("object_group", '\uf247');
		GLYPH_MAP.put("object_ungroup", '\uf248');
		GLYPH_MAP.put("odnoklassniki", '\uf263');
		GLYPH_MAP.put("odnoklassniki_square", '\uf264');
		GLYPH_MAP.put("opencart", '\uf23d');
		GLYPH_MAP.put("openid", '\uf19b');
		GLYPH_MAP.put("opera", '\uf26a');
		GLYPH_MAP.put("optin_monster", '\uf23c');
		GLYPH_MAP.put("outdent", '\uf03b');
		GLYPH_MAP.put("pagelines", '\uf18c');
		GLYPH_MAP.put("paint_brush", '\uf1fc');
		GLYPH_MAP.put("paper_plane", '\uf1d8');
		GLYPH_MAP.put("paper_plane_alt", '\uf1d9');
		GLYPH_MAP.put("paperclip", '\uf0c6');
		GLYPH_MAP.put("paragraph", '\uf1dd');
		GLYPH_MAP.put("paste", '\uf0ea');
		GLYPH_MAP.put("pause", '\uf04c');
		GLYPH_MAP.put("pause_circle", '\uf28b');
		GLYPH_MAP.put("pause_circle_alt", '\uf28c');
		GLYPH_MAP.put("paw", '\uf1b0');
		GLYPH_MAP.put("paypal", '\uf1ed');
		GLYPH_MAP.put("pencil", '\uf040');
		GLYPH_MAP.put("pencil_square", '\uf14b');
		GLYPH_MAP.put("pencil_square_alt", '\uf044');
		GLYPH_MAP.put("percent", '\uf295');
		GLYPH_MAP.put("phone", '\uf095');
		GLYPH_MAP.put("phone_square", '\uf098');
		GLYPH_MAP.put("photo", '\uf03e');
		GLYPH_MAP.put("picture_alt", '\uf03e');
		GLYPH_MAP.put("pie_chart", '\uf200');
		GLYPH_MAP.put("pied_piper", '\uf1a7');
		GLYPH_MAP.put("pied_piper_alt", '\uf1a8');
		GLYPH_MAP.put("pinterest", '\uf0d2');
		GLYPH_MAP.put("pinterest_p", '\uf231');
		GLYPH_MAP.put("pinterest_square", '\uf0d3');
		GLYPH_MAP.put("plane", '\uf072');
		GLYPH_MAP.put("play", '\uf04b');
		GLYPH_MAP.put("play_circle", '\uf144');
		GLYPH_MAP.put("play_circle_alt", '\uf01d');
		GLYPH_MAP.put("plug", '\uf1e6');
		GLYPH_MAP.put("plus", '\uf067');
		GLYPH_MAP.put("plus_circle", '\uf055');
		GLYPH_MAP.put("plus_square", '\uf0fe');
		GLYPH_MAP.put("plus_square_alt", '\uf196');
		GLYPH_MAP.put("power_off", '\uf011');
		GLYPH_MAP.put("print", '\uf02f');
		GLYPH_MAP.put("product_hunt", '\uf288');
		GLYPH_MAP.put("puzzle_piece", '\uf12e');
		GLYPH_MAP.put("qq", '\uf1d6');
		GLYPH_MAP.put("qrcode", '\uf029');
		GLYPH_MAP.put("question", '\uf128');
		GLYPH_MAP.put("question_circle", '\uf059');
		GLYPH_MAP.put("quote_left", '\uf10d');
		GLYPH_MAP.put("quote_right", '\uf10e');
		GLYPH_MAP.put("ra", '\uf1d0');
		GLYPH_MAP.put("random", '\uf074');
		GLYPH_MAP.put("rebel", '\uf1d0');
		GLYPH_MAP.put("recycle", '\uf1b8');
		GLYPH_MAP.put("reddit", '\uf1a1');
		GLYPH_MAP.put("reddit_alien", '\uf281');
		GLYPH_MAP.put("reddit_square", '\uf1a2');
		GLYPH_MAP.put("refresh", '\uf021');
		GLYPH_MAP.put("registered", '\uf25d');
		GLYPH_MAP.put("remove", '\uf00d');
		GLYPH_MAP.put("renren", '\uf18b');
		GLYPH_MAP.put("reorder", '\uf0c9');
		GLYPH_MAP.put("repeat", '\uf01e');
		GLYPH_MAP.put("reply", '\uf112');
		GLYPH_MAP.put("reply_all", '\uf122');
		GLYPH_MAP.put("retweet", '\uf079');
		GLYPH_MAP.put("rmb", '\uf157');
		GLYPH_MAP.put("road", '\uf018');
		GLYPH_MAP.put("rocket", '\uf135');
		GLYPH_MAP.put("rotate_left", '\uf0e2');
		GLYPH_MAP.put("rotate_right", '\uf01e');
		GLYPH_MAP.put("rouble", '\uf158');
		GLYPH_MAP.put("rss", '\uf09e');
		GLYPH_MAP.put("rss_square", '\uf143');
		GLYPH_MAP.put("rub", '\uf158');
		GLYPH_MAP.put("ruble", '\uf158');
		GLYPH_MAP.put("rupee", '\uf156');
		GLYPH_MAP.put("safari", '\uf267');
		GLYPH_MAP.put("save", '\uf0c7');
		GLYPH_MAP.put("scissors", '\uf0c4');
		GLYPH_MAP.put("scribd", '\uf28a');
		GLYPH_MAP.put("search", '\uf002');
		GLYPH_MAP.put("search_minus", '\uf010');
		GLYPH_MAP.put("search_plus", '\uf00e');
		GLYPH_MAP.put("sellsy", '\uf213');
		GLYPH_MAP.put("send", '\uf1d8');
		GLYPH_MAP.put("send_alt", '\uf1d9');
		GLYPH_MAP.put("server", '\uf233');
		GLYPH_MAP.put("share", '\uf064');
		GLYPH_MAP.put("share_alt", '\uf1e0');
		GLYPH_MAP.put("share_alt_square", '\uf1e1');
		GLYPH_MAP.put("share_square", '\uf14d');
		GLYPH_MAP.put("share_square_alt", '\uf045');
		GLYPH_MAP.put("shekel", '\uf20b');
		GLYPH_MAP.put("sheqel", '\uf20b');
		GLYPH_MAP.put("shield", '\uf132');
		GLYPH_MAP.put("ship", '\uf21a');
		GLYPH_MAP.put("shirtsinbulk", '\uf214');
		GLYPH_MAP.put("shopping_bag", '\uf290');
		GLYPH_MAP.put("shopping_basket", '\uf291');
		GLYPH_MAP.put("shopping_cart", '\uf07a');
		GLYPH_MAP.put("sign_in", '\uf090');
		GLYPH_MAP.put("sign_out", '\uf08b');
		GLYPH_MAP.put("signal", '\uf012');
		GLYPH_MAP.put("simplybuilt", '\uf215');
		GLYPH_MAP.put("sitemap", '\uf0e8');
		GLYPH_MAP.put("skyatlas", '\uf216');
		GLYPH_MAP.put("skype", '\uf17e');
		GLYPH_MAP.put("slack", '\uf198');
		GLYPH_MAP.put("sliders", '\uf1de');
		GLYPH_MAP.put("slideshare", '\uf1e7');
		GLYPH_MAP.put("smile_alt", '\uf118');
		GLYPH_MAP.put("soccer_ball_alt", '\uf1e3');
		GLYPH_MAP.put("sort", '\uf0dc');
		GLYPH_MAP.put("sort_alpha_asc", '\uf15d');
		GLYPH_MAP.put("sort_alpha_desc", '\uf15e');
		GLYPH_MAP.put("sort_amount_asc", '\uf160');
		GLYPH_MAP.put("sort_amount_desc", '\uf161');
		GLYPH_MAP.put("sort_asc", '\uf0de');
		GLYPH_MAP.put("sort_desc", '\uf0dd');
		GLYPH_MAP.put("sort_down", '\uf0dd');
		GLYPH_MAP.put("sort_numeric_asc", '\uf162');
		GLYPH_MAP.put("sort_numeric_desc", '\uf163');
		GLYPH_MAP.put("sort_up", '\uf0de');
		GLYPH_MAP.put("soundcloud", '\uf1be');
		GLYPH_MAP.put("space_shuttle", '\uf197');
		GLYPH_MAP.put("spinner", '\uf110');
		GLYPH_MAP.put("spoon", '\uf1b1');
		GLYPH_MAP.put("spotify", '\uf1bc');
		GLYPH_MAP.put("square", '\uf0c8');
		GLYPH_MAP.put("square_alt", '\uf096');
		GLYPH_MAP.put("stack_exchange", '\uf18d');
		GLYPH_MAP.put("stack_overflow", '\uf16c');
		GLYPH_MAP.put("star", '\uf005');
		GLYPH_MAP.put("star_half", '\uf089');
		GLYPH_MAP.put("star_half_empty", '\uf123');
		GLYPH_MAP.put("star_half_full", '\uf123');
		GLYPH_MAP.put("star_half_alt", '\uf123');
		GLYPH_MAP.put("star_alt", '\uf006');
		GLYPH_MAP.put("steam", '\uf1b6');
		GLYPH_MAP.put("steam_square", '\uf1b7');
		GLYPH_MAP.put("step_backward", '\uf048');
		GLYPH_MAP.put("step_forward", '\uf051');
		GLYPH_MAP.put("stethoscope", '\uf0f1');
		GLYPH_MAP.put("sticky_note", '\uf249');
		GLYPH_MAP.put("sticky_note_alt", '\uf24a');
		GLYPH_MAP.put("stop", '\uf04d');
		GLYPH_MAP.put("stop_circle", '\uf28d');
		GLYPH_MAP.put("stop_circle_alt", '\uf28e');
		GLYPH_MAP.put("street_view", '\uf21d');
		GLYPH_MAP.put("strikethrough", '\uf0cc');
		GLYPH_MAP.put("stumbleupon", '\uf1a4');
		GLYPH_MAP.put("stumbleupon_circle", '\uf1a3');
		GLYPH_MAP.put("subscript", '\uf12c');
		GLYPH_MAP.put("subway", '\uf239');
		GLYPH_MAP.put("suitcase", '\uf0f2');
		GLYPH_MAP.put("sun_alt", '\uf185');
		GLYPH_MAP.put("superscript", '\uf12b');
		GLYPH_MAP.put("support", '\uf1cd');
		GLYPH_MAP.put("table", '\uf0ce');
		GLYPH_MAP.put("tablet", '\uf10a');
		GLYPH_MAP.put("tachometer", '\uf0e4');
		GLYPH_MAP.put("tag", '\uf02b');
		GLYPH_MAP.put("tags", '\uf02c');
		GLYPH_MAP.put("tasks", '\uf0ae');
		GLYPH_MAP.put("taxi", '\uf1ba');
		GLYPH_MAP.put("television", '\uf26c');
		GLYPH_MAP.put("tencent_weibo", '\uf1d5');
		GLYPH_MAP.put("terminal", '\uf120');
		GLYPH_MAP.put("text_height", '\uf034');
		GLYPH_MAP.put("text_width", '\uf035');
		GLYPH_MAP.put("th", '\uf00a');
		GLYPH_MAP.put("th_large", '\uf009');
		GLYPH_MAP.put("th_list", '\uf00b');
		GLYPH_MAP.put("thumb_tack", '\uf08d');
		GLYPH_MAP.put("thumbs_down", '\uf165');
		GLYPH_MAP.put("thumbs_alt_down", '\uf088');
		GLYPH_MAP.put("thumbs_alt_up", '\uf087');
		GLYPH_MAP.put("thumbs_up", '\uf164');
		GLYPH_MAP.put("ticket", '\uf145');
		GLYPH_MAP.put("times", '\uf00d');
		GLYPH_MAP.put("times_circle", '\uf057');
		GLYPH_MAP.put("times_circle_alt", '\uf05c');
		GLYPH_MAP.put("tint", '\uf043');
		GLYPH_MAP.put("toggle_down", '\uf150');
		GLYPH_MAP.put("toggle_left", '\uf191');
		GLYPH_MAP.put("toggle_off", '\uf204');
		GLYPH_MAP.put("toggle_on", '\uf205');
		GLYPH_MAP.put("toggle_right", '\uf152');
		GLYPH_MAP.put("toggle_up", '\uf151');
		GLYPH_MAP.put("trademark", '\uf25c');
		GLYPH_MAP.put("train", '\uf238');
		GLYPH_MAP.put("transgender", '\uf224');
		GLYPH_MAP.put("transgender_alt", '\uf225');
		GLYPH_MAP.put("trash", '\uf1f8');
		GLYPH_MAP.put("trash_alt", '\uf014');
		GLYPH_MAP.put("tree", '\uf1bb');
		GLYPH_MAP.put("trello", '\uf181');
		GLYPH_MAP.put("tripadvisor", '\uf262');
		GLYPH_MAP.put("trophy", '\uf091');
		GLYPH_MAP.put("truck", '\uf0d1');
		GLYPH_MAP.put("try", '\uf195');
		GLYPH_MAP.put("tty", '\uf1e4');
		GLYPH_MAP.put("tumblr", '\uf173');
		GLYPH_MAP.put("tumblr_square", '\uf174');
		GLYPH_MAP.put("turkish_lira", '\uf195');
		GLYPH_MAP.put("tv", '\uf26c');
		GLYPH_MAP.put("twitch", '\uf1e8');
		GLYPH_MAP.put("twitter", '\uf099');
		GLYPH_MAP.put("twitter_square", '\uf081');
		GLYPH_MAP.put("umbrella", '\uf0e9');
		GLYPH_MAP.put("underline", '\uf0cd');
		GLYPH_MAP.put("undo", '\uf0e2');
		GLYPH_MAP.put("university", '\uf19c');
		GLYPH_MAP.put("unlink", '\uf127');
		GLYPH_MAP.put("unlock", '\uf09c');
		GLYPH_MAP.put("unlock_alt", '\uf13e');
		GLYPH_MAP.put("unsorted", '\uf0dc');
		GLYPH_MAP.put("upload", '\uf093');
		GLYPH_MAP.put("usb", '\uf287');
		GLYPH_MAP.put("usd", '\uf155');
		GLYPH_MAP.put("user", '\uf007');
		GLYPH_MAP.put("user_md", '\uf0f0');
		GLYPH_MAP.put("user_plus", '\uf234');
		GLYPH_MAP.put("user_secret", '\uf21b');
		GLYPH_MAP.put("user_times", '\uf235');
		GLYPH_MAP.put("users", '\uf0c0');
		GLYPH_MAP.put("venus", '\uf221');
		GLYPH_MAP.put("venus_double", '\uf226');
		GLYPH_MAP.put("venus_mars", '\uf228');
		GLYPH_MAP.put("viacoin", '\uf237');
		GLYPH_MAP.put("video_camera", '\uf03d');
		GLYPH_MAP.put("vimeo", '\uf27d');
		GLYPH_MAP.put("vimeo_square", '\uf194');
		GLYPH_MAP.put("vine", '\uf1ca');
		GLYPH_MAP.put("vk", '\uf189');
		GLYPH_MAP.put("volume_down", '\uf027');
		GLYPH_MAP.put("volume_off", '\uf026');
		GLYPH_MAP.put("volume_up", '\uf028');
		GLYPH_MAP.put("warning", '\uf071');
		GLYPH_MAP.put("wechat", '\uf1d7');
		GLYPH_MAP.put("weibo", '\uf18a');
		GLYPH_MAP.put("weixin", '\uf1d7');
		GLYPH_MAP.put("whatsapp", '\uf232');
		GLYPH_MAP.put("wheelchair", '\uf193');
		GLYPH_MAP.put("wifi", '\uf1eb');
		GLYPH_MAP.put("wikipedia_w", '\uf266');
		GLYPH_MAP.put("windows", '\uf17a');
		GLYPH_MAP.put("won", '\uf159');
		GLYPH_MAP.put("wordpress", '\uf19a');
		GLYPH_MAP.put("wrench", '\uf0ad');
		GLYPH_MAP.put("xing", '\uf168');
		GLYPH_MAP.put("xing_square", '\uf169');
		GLYPH_MAP.put("y_combinator", '\uf23b');
		GLYPH_MAP.put("y_combinator_square", '\uf1d4');
		GLYPH_MAP.put("yahoo", '\uf19e');
		GLYPH_MAP.put("yc", '\uf23b');
		GLYPH_MAP.put("yc_square", '\uf1d4');
		GLYPH_MAP.put("yelp", '\uf1e9');
		GLYPH_MAP.put("yen", '\uf157');
		GLYPH_MAP.put("youtube", '\uf167');
		GLYPH_MAP.put("youtube_play", '\uf16a');
		GLYPH_MAP.put("youtube_square", '\uf166');
	}

	public static Button createGlyphButton(String glyphName,String btnName, int sizeFactor,Color nameColor, Color color0, Color color1, String btnStyle, String hoverStyle) {
		Label lbl = new Label();
		lbl.setFont(Font.font(GLYPH_FONTAWESOME.getFamily(), 8 * sizeFactor));
		Stop[] stops = new Stop[] { new Stop(0, color0), new Stop(1, color1) };
		LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
		lbl.setText(String.valueOf(GLYPH_MAP.get(glyphName)));
		lbl.setTextFill(lg1);
		Button btn = new Button(btnName, lbl);
		btn.setWrapText(true);
		btn.setContentDisplay(ContentDisplay.TOP);
		btn.setStyle(btnStyle);
		btn.setTextFill(nameColor);
		btn.setCursor(Cursor.HAND);
		
		btn.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				btn.setStyle(hoverStyle);				
			}
		});
		btn.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				btn.setStyle(btnStyle);
				btn.setTextFill(nameColor);
			}
		});
		return btn;
	}

}
