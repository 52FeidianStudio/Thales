package cn.thales.aop.joinpoint;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/26 10:32
 * @Description: null
 */
public class JdkRegexMethodPointcut implements MethodMatcher, Pointcut{
    private Pattern[] compiledPatterns = new Pattern[0];
    @Override
    public ClassFilter getClassFilter() {
        return null;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        String name = method.getName();
        for (Pattern pattern :compiledPatterns) {
            Matcher matcher = pattern.matcher(name);
            if(matcher.matches()){
                return true;
            }
        }
        return false;
    }
    private Pattern[] compilePatterns(String[] source) throws PatternSyntaxException {
        Pattern[] destination = new Pattern[source.length];
        for (int i = 0; i < source.length; i++) {
            destination[i] = Pattern.compile(source[i]);
        }
        return destination;
    }
    public void initPatternRepresentation(String[] patterns) throws PatternSyntaxException {
        this.compiledPatterns = compilePatterns(patterns);
    }
}
