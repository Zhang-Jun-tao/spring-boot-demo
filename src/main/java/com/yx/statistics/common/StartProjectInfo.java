package com.yx.statistics.common;

/**
 * Created by zhang on 2016/12/11.
 */
public class StartProjectInfo {
    public static String getProfileString(String str){
        StringBuffer sb=new StringBuffer();
        sb.append("\n");
        if(str.trim().equals("text")){
            sb.append(" *                 *\n");
            sb.append("*****  **  ** ** *****\n");
            sb.append(" *    *  *  * *    * \n");
            sb.append(" *    ****   *     *\n");
            sb.append(" *    *     * *    *\n");
            sb.append(" ***   *** ** **   ***\n");
        }else if(str.trim().equals("dev")){
            sb.append("	   **               \n");
            sb.append("	    *               \n");
            sb.append("	    *               \n");
            sb.append("	  ***   **  ** **   \n");
            sb.append("	 *  *  *  *  * *    \n");
            sb.append("	 *  *  ****  * *    \n");
            sb.append("	 *  *  *      *     \n");
            sb.append("	  ****  ***   *     \n");
        }else if(str.trim().equals("prod")){
            sb.append("			             **\n");
            sb.append("			             *\n");
            sb.append("			             *\n");
            sb.append("****  ** **   **    ***\n");
            sb.append("*  *  **    *  *  *  *\n");
            sb.append("*  *  *     *  *  *  *\n");
            sb.append("*  *  *     *  *  *  *\n");
            sb.append("***  ***     **    ****\n");
            sb.append("*\n");
            sb.append("***\n");
        }
        return sb.toString();
    }


    public static  String getProjectProtector(){
        StringBuffer sb = new StringBuffer("\n");
        sb.append("                   _ooOoo_\n");
        sb.append("                  o8888888o\n");
        sb.append("                  88\" . \"88\n");
        sb.append("                  (| -_- |)\n");
        sb.append("                  O\\  =  /O\n");
        sb.append("               ____/`---'\\____\n");
        sb.append("             .'  \\\\|     |//  `.\n");
        sb.append("            /  \\\\|||  :  |||//  \\ \n");
        sb.append("           /  _||||| -:- |||||-  \\ \n");
        sb.append("           |   | \\\\\\  -  /// |   |\n");
        sb.append("           | \\_|  ''\\---/''  |   |\n");
        sb.append("           \\  .-\\__  `-`  ___/-. /\n");
        sb.append("         ___`. .'  /--.--\\  `. . __\n");
        sb.append("      .\"\" '<  `.___\\_<|>_/___.'  >'\"\".\n");
        sb.append("     | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\n");
        sb.append("     \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /\n");
        sb.append("======`-.____`-.___\\_____/___.-`____.-'======\n");
        sb.append("                   `=---='\n");
        sb.append("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
        sb.append("\t\t佛祖保佑       永无BUG\n");
        sb.append("\t\t写字楼里写字间，写字间里程序员； \n");
        sb.append("\t\t程序人员写程序，又拿程序换酒钱。\n");
        sb.append("\t\t酒醒只在网上坐，酒醉还来网下眠；\n");
        sb.append("\t\t酒醉酒醒日复日，网上网下年复年。\n");
        sb.append("\t\t但愿老死电脑间，不愿鞠躬老板前；\n");
        sb.append("\t\t奔驰宝马贵者趣，公交自行程序员。\n");
        sb.append("\t\t别人笑我忒疯癫，我笑自己命太贱；\n");
        sb.append("\t\t不见满街漂亮妹，哪个归得程序员？\n");
        return sb.toString();
    }
}
