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
		// 设置编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter writer = resp.getWriter();
		/**
		 * 第一步：用户同意授权，获取code:https://open.weixin.qq.com/connect/oauth2/authorize
		 * ?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE
		 * &state=STATE#wechat_redirect
		 */
		// 已经在GuideServlet进行了处理

		/**
		 * 第二步：通过code换取网页授权access_token
		 */
		String code = req.getParameter("code");// 获取返回码
		// 同意授权
		if (code != null) {
			// 拼接请求地址
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid=" + APPID + "&secret=" + SECERT
					+ "&code=" + code + "&grant_type=authorization_code";
			String json = getReturnJson(url, null);// 拿去返回值
			writer.println(json);
			writer.flush();
			writer.close();
			// AutoWebParams autoWebParams = new AutoWebParams();
			// Gson gson = new Gson();
			// autoWebParams = gson.fromJson(json, new
			// AutoWebParams().getClass());
			//
			// /**
			// * 第三步：刷新access_token（如果需要）
			// */
			// String url2 =
			// "https://api.weixin.qq.com/sns/oauth2/refresh_token?" + "appid="
			// + GlobalParams.APPID
			// + "&grant_type=refresh_token&refresh_token=" +
			// autoWebParams.getRefresh_token();
			// String json2 = MyHttpUtils.getReturnJson(url2, null);// 拿去返回值
			// AutoWebParams autoWebParams2 = new AutoWebParams();
			// Gson gson2 = new Gson();
			// autoWebParams2 = gson2.fromJson(json2, new
			// AutoWebParams().getClass());
			//
			// /**
			// * 第四步：拉取用户信息(需scope为 snsapi_userinfo)
			// */
			// String url3 =
			// "https://api.weixin.qq.com/sns/userinfo?access_token=" +
			// autoWebParams2.getAccess_token()
			// + "&openid=" + autoWebParams2.getOpenid() + "&lang=zh_CN";
			// String json3 = MyHttpUtils.getReturnJson(url3, null);// 拿去返回值
			// UserInfo userInfo = new UserInfo();
			// Gson gson3 = new Gson();
			// userInfo = gson3.fromJson(new String(json3.getBytes(), "utf-8"),
			// new UserInfo().getClass());
			// System.out.println(userInfo);
			// -----------------------操作结束-------------------------

			// 显示用户信息
			// req.setAttribute("userInfo", userInfo);
			// req.getRequestDispatcher("userinfo.jsp").forward(req, resp);

		} else {
			writer.print("用户禁止授权，这里处理禁止之后的操作");
			writer.close();
		}
	}

	public static String getReturnJson(String url, String osrJson) {
		String reslut = "";// 返回的结果json
		try {
			// 创建一个url
			URL reqURL = new URL(url);
			// 拿取链接
			HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL.openConnection();
			// 当需要参数传递时，才执行该方法
			if (osrJson != null) {
				httpsConn.setDoOutput(true);
				// 取得该连接的输出流，以读取响应内容
				OutputStreamWriter osr = new OutputStreamWriter(httpsConn.getOutputStream());
				osr.write(osrJson);// 写请求数据
				osr.close();
			}

			// 返回结果
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
