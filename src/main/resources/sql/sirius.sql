/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50152
Source Host           : localhost:3306
Source Database       : sirius

Target Server Type    : MYSQL
Target Server Version : 50152
File Encoding         : 65001

Date: 2018-10-13 23:44:24
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `articleId` int(11) NOT NULL AUTO_INCREMENT,
  `articleCreatorId` varchar(255) DEFAULT NULL,
  `articleTitle` varchar(255) DEFAULT NULL,
  `articleContent` varchar(6000) DEFAULT NULL,
  `articleCategoryIds` varchar(255) DEFAULT NULL,
  `articleTags` varchar(255) DEFAULT NULL,
  `articleCreateTime` varchar(255) DEFAULT NULL,
  `articleCommentStatus` varchar(255) DEFAULT NULL,
  `articleStatus` varchar(255) DEFAULT NULL,
  `articleViewCount` int(11) DEFAULT '0',
  `articleCommentCount` int(11) DEFAULT '0',
  `articleLikeCount` int(11) DEFAULT '0',
  PRIMARY KEY (`articleId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '17865168830', 'SpringBoot从入门到精通', 'Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者', '1,2', 'java,sql', '2018-8-13 07:49:22', '1', '1', '99', '99', '99');
INSERT INTO `article` VALUES ('2', '17865168830', 'SpringBoot从入门到精通', 'Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者', '1,2', 'java,sql', '2018-8-13 07:49:22', '1', '1', '99', '99', '99');
INSERT INTO `article` VALUES ('3', '17865168830', 'SpringBoot从入门到精通', 'Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者', '1,2', 'java,sql', '2018-8-13 07:49:22', '1', '1', '99', '99', '99');
INSERT INTO `article` VALUES ('4', '17865168830', 'SpringBoot从入门到精通', 'Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者', '1,2', 'java,sql', '2018-8-13 07:49:22', '1', '1', '99', '99', '99');
INSERT INTO `article` VALUES ('5', '17865168830', 'SpringBoot从入门到精通', 'Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者', '1,2', 'java,sql', '2018-8-13 07:49:22', '1', '1', '99', '99', '99');
INSERT INTO `article` VALUES ('6', '17865168830', 'java入门', 'java从入门到跑路', '1,2', 'java,sql', '2018-7-13 07:49:22', '1', '1', '99', '99', '99');
INSERT INTO `article` VALUES ('7', '17865168830', 'java入门', 'java从入门到跑路', '1,2', 'java,sql', '2018-7-13 07:49:22', '1', '1', '99', '99', '99');
INSERT INTO `article` VALUES ('8', '17865168830', 'java入门', 'java从入门到跑路', '1,2', 'java,sql', '2018-7-13 07:49:22', '1', '1', '99', '99', '99');
INSERT INTO `article` VALUES ('9', 'hly', 'MarkDown语法', '### 主要特性\n\n- 支持“标准”Markdown / CommonMark和Github风格的语法，也可变身为代码编辑器；\n- 支持实时预览、图片（跨域）上传、预格式文本/代码/表格插入、代码折叠、搜索替换、只读模式、自定义样式主题和多语言语法高亮等功能；\n- 支持ToC（Table of Contents）、Emoji表情、Task lists、@链接等Markdown扩展语法；\n- 支持TeX科学公式（基于KaTeX）、流程图 Flowchart 和 时序图 Sequence Diagram;\n- 支持识别和解析HTML标签，并且支持自定义过滤标签解析，具有可靠的安全性和几乎无限的扩展性；\n- 支持 AMD / CMD 模块化加载（支持 Require.js & Sea.js），并且支持自定义扩展插件；\n- 兼容主流的浏览器（IE8+）和Zepto.js，且支持iPad等平板设备；\n- 支持自定义主题样式；\n\n# Editor.md\n\n![](https://pandao.github.io/editor.md/images/logos/editormd-logo-180x180.png)\n\n![](https://img.shields.io/github/stars/pandao/editor.md.svg) ![](https://img.shields.io/github/forks/pandao/editor.md.svg) ![](https://img.shields.io/github/tag/pandao/editor.md.svg) ![](https://img.shields.io/github/release/pandao/editor.md.svg) ![](https://img.shields.io/github/issues/pandao/editor.md.svg) ![](https://img.shields.io/bower/v/editor.md.svg)\n\n**目录 (Table of Contents)**\n\n[TOCM]\n\n[TOC]\n\n# Heading 1\n## Heading 2\n### Heading 3\n#### Heading 4\n##### Heading 5\n###### Heading 6\n# Heading 1 link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\n## Heading 2 link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\n### Heading 3 link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\n#### Heading 4 link [Heading link](https://github.com/pandao/editor.md \"Heading link\") Heading link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\n##### Heading 5 link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\n###### Heading 6 link [Heading link](https://github.com/pandao/editor.md \"Heading link\")\n\n#### 标题（用底线的形式）Heading (underline)\n\nThis is an H1\n=============\n\nThis is an H2\n-------------\n\n### 字符效果和横线等\n\n----\n\n~~删除线~~ <s>删除线（开启识别HTML标签时）</s>\n*斜体字*      _斜体字_\n**粗体**  __粗体__\n***粗斜体*** ___粗斜体___\n\n上标：X<sub>2</sub>，下标：O<sup>2</sup>\n\n**缩写(同HTML的abbr标签)**\n\n> 即更长的单词或短语的缩写形式，前提是开启识别HTML标签时，已默认开启\n\nThe <abbr title=\"Hyper Text Markup Language\">HTML</abbr> specification is maintained by the <abbr title=\"World Wide Web Consortium\">W3C</abbr>.\n\n### 引用 Blockquotes\n\n> 引用文本 Blockquotes\n\n引用的行内混合 Blockquotes\n\n> 引用：如果想要插入空白换行`即<br />标签`，在插入处先键入两个以上的空格然后回车即可，[普通链接](http://localhost/)。\n\n### 锚点与链接 Links\n\n[普通链接](http://localhost/)\n\n[普通链接带标题](http://localhost/ \"普通链接带标题\")\n\n直接链接：<https://github.com>\n\n[锚点链接][anchor-id]\n\n[anchor-id]: http://www.this-anchor-link.com/\n\nGFM a-tail link @pandao\n\n> @pandao\n\n### 多语言代码高亮 Codes\n\n#### 行内代码 Inline code\n\n执行命令：`npm install marked`\n\n#### 缩进风格\n\n即缩进四个空格，也做为实现类似`<pre>`预格式化文本(Preformatted Text)的功能。\n\n        <?php\n        echo \"Hello world!\";\n    ?>\n\n        预格式化文本：\n\n    | First Header  | Second Header |\n    | ------------- | ------------- |\n    | Content Cell  | Content Cell  |\n    | Content Cell  | Content Cell  |\n\n#### JS代码　\n\n```javascript\nfunction test(){\n	console.log(\"Hello world!\");\n}\n\n(function(){\n    var box = function(){\n        return box.fn.init();\n    };\n\n    box.prototype = box.fn = {\n        init : function(){\n            console.log(\'box.init()\');\n\n			return this;\n        },\n\n		add : function(str){\n			alert(\"add\", str);\n\n			return this;\n		},\n\n		remove : function(str){\n			alert(\"remove\", str);\n\n			return this;\n		}\n    };\n\n    box.fn.init.prototype = box.fn;\n\n    window.box =box;\n})();\n\nvar testBox = box();\ntestBox.add(\"jQuery\").remove(\"jQuery\");\n```\n\n#### HTML代码 HTML codes\n\n```html\n<!DOCTYPE html>\n<html>\n    <head>\n        <mate charest=\"utf-8\" />\n        <title>Hello world!</title>\n    </head>\n    <body>\n        <h1>Hello world!</h1>\n    </body>\n</html>\n```', '', '', '2018-10-13 11:41:26', '1', '1', '0', '0', '0');

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `userIP` varchar(255) DEFAULT NULL,
  `actionClassName` varchar(6000) DEFAULT NULL,
  `actionDate` varchar(255) DEFAULT NULL,
  `result` varchar(6000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', '', '', 'com.hly.sirius.filter.VisitorFilter', '2018-10-03 03:07:08', '用户：hly');
INSERT INTO `log` VALUES ('2', '', '', 'com.hly.sirius.filter.VisitorFilter', '2018-10-03 03:14:52', '用户：hly');
INSERT INTO `log` VALUES ('3', 'hly', '', 'com.hly.sirius.filter.VisitorFilter', '2018-10-03 03:17:10', '用户：hly');
INSERT INTO `log` VALUES ('4', 'hly', '', 'com.hly.sirius.filter.VisitorFilter', '2018-10-03 03:36:08', '用户：hly');
INSERT INTO `log` VALUES ('5', 'hly', '', 'com.hly.sirius.filter.VisitorFilter', '2018-10-03 03:40:15', '用户：hly');
INSERT INTO `log` VALUES ('6', 'hly', '', 'com.hly.sirius.filter.VisitorFilter', '2018-10-03 04:00:54', '用户：hly');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('hly', '6a855b873a49703125eab20222efde86');

-- ----------------------------
-- Table structure for `visitor`
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `visitorId` int(11) NOT NULL AUTO_INCREMENT,
  `visitorName` varchar(255) DEFAULT NULL,
  `visitorQQ` varchar(255) DEFAULT NULL,
  `visitorTel` varchar(255) DEFAULT NULL,
  `visitorEmail` varchar(255) DEFAULT NULL,
  `visitorBlog` varchar(255) DEFAULT NULL,
  `visitorGithub` varchar(255) DEFAULT NULL,
  `visitorIP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`visitorId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visitor
-- ----------------------------
INSERT INTO `visitor` VALUES ('1', 'sirius', null, '17865168830', null, null, null, null);
