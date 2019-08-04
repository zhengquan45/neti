package com.zhq.neti;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.script.JavaScriptEngine;
import cn.hutool.script.ScriptUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.script.ScriptException;

@SpringBootTest
public class NetiApplicationTests {



    @Test
    public void test2() throws ScriptException {
        JavaScriptEngine scriptEngine = ScriptUtil.getJavaScriptEngine();
        String url = "https://cdn.bootcss.com/Mock.js/1.0.1-beta3/mock-min.js";
        String scriptString = HttpUtil.downloadString(url, CharsetUtil.UTF_8);
        scriptEngine.eval(scriptString);
        Object eval = scriptEngine.eval("Mock.Random.boolean()");
        System.out.println(eval);
    }


}
