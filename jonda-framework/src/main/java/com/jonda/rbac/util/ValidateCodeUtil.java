package com.jonda.rbac.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ValidateCodeUtil {

    public static final Integer DEFAULT_CODE_LENGTH = 4;

    public static final String VALIDATE_CODE_KEY = "VALIDATE_CODE_KEY";

	/**
	 * 验证码图片的宽度。
	 */
	private static int width = 60;

	/**
	 * 验证码图片的高度。
	 */
	private static int height = 20;

	/**
	 * 字体高度
	 */
	private static int fontHeight = 17;


	/**
	 * codeSequence
	 */
	private static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public static BufferedImage generateImage(String code) {
		
		// 获取HttpServletRequest对象
		
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.PLAIN, fontHeight));
		g.setColor(getRandColor(150, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		
		int i = 0 ;
		int charWidth = width / code.length()  ;
		for (char c : code.toCharArray()) {
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(String.valueOf(c), charWidth * i, 16);
			i ++ ;
		}

		return image;
	}


    public static String getCode() {
        return getCode(DEFAULT_CODE_LENGTH);
    }

	public static String getCode(int codeCount) {
		Random random = new Random();
		String sRand = "";
		for(int i = 0 ; i < codeCount ; i++) {
			String rand = String.valueOf(codeSequence[random.nextInt(36)]);
			int charCase = random.nextInt() ;
			if(charCase % 2 == 0) {
				sRand += rand.toLowerCase() ;
			} else {
				sRand += rand;
			}
		}
		return sRand ;
	}
	
	private static Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
}
