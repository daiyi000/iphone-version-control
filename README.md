# iphone-version-control

---

# iPhone版本号控制系统

## 项目简介

iPhone版本号控制系统是一个基于Spring Boot框架开发的管理系统，旨在帮助开发者和团队高效管理iPhone应用的版本号。系统支持版本号的增、删、改、查等操作，并提供友好的前端界面，方便用户进行版本管理。

## 功能特点

- **版本管理**：支持iPhone应用版本号的增、删、改、查操作。
- **版本分类**：可根据应用的不同类别进行版本号分类管理。
- **版本查询**：用户可以根据不同的查询条件，如版本号、发布日期等进行搜索。
- **数据存储**：所有版本信息存储在数据库中，确保数据持久化。
- **用户权限**：系统支持管理员权限管理，确保操作的安全性。

## 技术栈

- **后端**：Spring Boot
- **数据库**：MySQL
- **前端**：HTML, CSS, JavaScript
- **依赖管理**：Maven



## 安装与配置

### 1. 克隆项目

首先，您可以将项目克隆到本地：

```bash
git clone https://github.com/daiyi000/iphone-version-control.git
```

### 2. 配置数据库

确保您已经安装了MySQL并创建了一个数据库。例如，您可以创建一个名为`iphone_version_db`的数据库。

```sql
CREATE DATABASE iphone_version_db;
```

配置`src/main/resources/application.properties`中的数据库连接：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/iphone_version_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. 构建和运行项目

确保您已经安装了Maven，然后运行以下命令来构建并启动项目：

```bash
mvn clean install
mvn spring-boot:run
```

默认情况下，系统会在`http://localhost:8080`上启动。

## 功能说明

### 1. 版本管理

- **新增版本**：管理员可以新增iPhone应用版本号，包括版本名称、发布日期、应用类型等信息。
- **修改版本**：管理员可以编辑已有的版本信息。
- **删除版本**：管理员可以删除不再需要的版本信息。
- **查询版本**：用户可以根据版本号、日期等条件查询版本信息。

### 2. 用户权限管理

系统提供了管理员权限管理功能，确保只有授权用户才能执行管理操作。

## API文档

### 1. 获取所有版本

- **URL**: `/api/versions`
- **方法**: `GET`
- **参数**: 无
- **返回**: 返回所有版本的列表。

### 2. 获取特定版本

- **URL**: `/api/versions/{id}`
- **方法**: `GET`
- **参数**: `id` - 版本的ID。
- **返回**: 返回特定版本的详细信息。

### 3. 创建新版本

- **URL**: `/api/versions`
- **方法**: `POST`
- **参数**: 包含版本信息的JSON数据（例如版本号、名称、发布日期等）。
- **返回**: 创建成功的版本信息。

### 4. 更新版本

- **URL**: `/api/versions/{id}`
- **方法**: `PUT`
- **参数**: 包含更新后的版本信息的JSON数据。
- **返回**: 更新后的版本信息。

### 5. 删除版本

- **URL**: `/api/versions/{id}`
- **方法**: `DELETE`
- **参数**: `id` - 版本的ID。
- **返回**: 删除成功的消息。

## 贡献

欢迎提交问题和拉取请求。如果您发现了BUG或有建议，请在GitHub上创建一个问题（Issue）或提交PR。

## 许可证

该项目使用MIT许可证。详情请参阅LICENSE文件。

---
