//package com.zq.demo;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//
//public class Generator {
//    public static void main(String[] args) {
//        AutoGenerator autoGenerator = new AutoGenerator();
////        数据库配置
//        DataSourceConfig dataSource = new DataSourceConfig();
//        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/Motion management system?serverTimezone=UTC");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//        autoGenerator.setDataSource(dataSource);
//
////        全局配置
//        GlobalConfig globalConfig = new GlobalConfig();
//        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java"); // 生成代码的路径
//        globalConfig.setOpen(false);
//        globalConfig.setAuthor("GL");
//        globalConfig.setFileOverride(true);
//        globalConfig.setMapperName("%sDao");
//        globalConfig.setIdType(IdType.ASSIGN_ID); // 设置Id的生成策略
//        autoGenerator.setGlobalConfig(globalConfig);
////        包设置
//        PackageConfig packageInfo = new PackageConfig();
//        packageInfo.setParent("com.zq.demo");
//        packageInfo.setEntity("pojo"); // 设置实体类包
//        packageInfo.setMapper("dao");
//        autoGenerator.setPackageInfo(packageInfo);
////       策略配置
//        StrategyConfig strategy = new StrategyConfig();
////        strategy.setInclude("black_list","t_chat","t_chat_content","t_lob_content","t_lobby_chat");   // 数据库表
//        strategy.setTablePrefix("tb_", "t_");
//        strategy.setRestControllerStyle(true);
//        strategy.setEntityLombokModel(true);
//        strategy.setLogicDeleteFieldName("deleted");
//        strategy.setVersionFieldName("version");
//        autoGenerator.setStrategy(strategy);
////        autoGenerator.execute();
//    }
//}
