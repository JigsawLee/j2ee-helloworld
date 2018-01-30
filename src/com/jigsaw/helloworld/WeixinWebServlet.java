package com.jigsaw.helloworld;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.ssl.HttpsURLConnection;

public class WeixinWebServlet extends HttpServlet {
	private final static String APPID = "";
	private final static String SECERT = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ���ñ���
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter writer = resp.getWriter();
		/**
		 * ��һ�����û�ͬ����Ȩ����ȡcode:https://open.weixin.qq.com/connect/oauth2/authorize
		 * ?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE
		 * &state=STATE#wechat_redirect
		 */
		// �Ѿ���GuideServlet�����˴���

		/**
		 * �ڶ�����ͨ��code��ȡ��ҳ��Ȩaccess_token
		 */
		String code = req.getParameter("code");// ��ȡ������
		// ͬ����Ȩ
		if (code != null) {
			// ƴ�������ַ
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid=" + APPID + "&secret=" + SECERT
					+ "&code=" + code + "&grant_type=authorization_code";
			String json = getReturnJson(url, null);// ��ȥ����ֵ
			writer.println(json);
			writer.flush();
			writer.close();
			// AutoWebParams autoWebParams = new AutoWebParams();
			// Gson gson = new Gson();
			// autoWebParams = gson.fromJson(json, new
			// AutoWebParams().getClass());
			//
			// /**
			// * ��������ˢ��access_token�������Ҫ��
			// */
			// String url2 =
			// "https://api.weixin.qq.com/sns/oauth2/refresh_token?" + "appid="
			// + GlobalParams.APPID
			// + "&grant_type=refresh_token&refresh_token=" +
			// autoWebParams.getRefresh_token();
			// String json2 = MyHttpUtils.getReturnJson(url2, null);// ��ȥ����ֵ
			// AutoWebParams autoWebParams2 = new AutoWebParams();
			// Gson gson2 = new Gson();
			// autoWebParams2 = gson2.fromJson(json2, new
			// AutoWebParams().getClass());
			//
			// /**
			// * ���Ĳ�����ȡ�û���Ϣ(��scopeΪ snsapi_userinfo)
			// */
			// String url3 =
			// "https://api.weixin.qq.com/sns/userinfo?access_token=" +
			// autoWebParams2.getAccess_token()
			// + "&openid=" + autoWebParams2.getOpenid() + "&lang=zh_CN";
			// String json3 = MyHttpUtils.getReturnJson(url3, null);// ��ȥ����ֵ
			// UserInfo userInfo = new UserInfo();
			// Gson gson3 = new Gson();
			// userInfo = gson3.fromJson(new String(json3.getBytes(), "utf-8"),
			// new UserInfo().getClass());
			// System.out.println(userInfo);
			// -----------------------��������-------------------------

			// ��ʾ�û���Ϣ
			// req.setAttribute("userInfo", userInfo);
			// req.getRequestDispatcher("userinfo.jsp").forward(req, resp);

		} else {
			writer.print("�û���ֹ��Ȩ�����ﴦ���ֹ֮��Ĳ���");
			writer.close();
		}
	}

	public static String getReturnJson(String url, String osrJson) {
		String reslut = "";// ���صĽ��json
		try {
			// ����һ��url
			URL reqURL = new URL(url);
			// ��ȡ����
			HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL.openConnection();
			// ����Ҫ��������ʱ����ִ�и÷���
			if (osrJson != null) {
				httpsConn.setDoOutput(true);
				// ȡ�ø����ӵ���������Զ�ȡ��Ӧ����
				OutputStreamWriter osr = new OutputStreamWriter(httpsConn.getOutputStream());
				osr.write(osrJson);// д��������
				osr.close();
			}

			// ���ؽ��
			InputStreamReader isr = new InputStreamReader(httpsConn.getInputStream());
			char[] chars = new char[1024];
			int len;
			while ((len = isr.read(chars)) != -1) {
				reslut += new String(chars, 0, len);
			}
			isr.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reslut;
	}
}
