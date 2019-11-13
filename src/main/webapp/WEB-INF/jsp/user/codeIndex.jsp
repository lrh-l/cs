
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>jQuery实现省级联动</title>
</head>
<body>

<div>
    <select id="province" name="province">
        <option value="">--请选择--</option>
    </select>省
    <select id="city" name="city">
        <option value="">--请选择--</option>
    </select>市
    <select id="district" name="district">
        <option value="">--请选择--</option>
    </select>区/县

</div>

<script type="text/javascript" src="js/data.js" ></script>
<script type="text/javascript" src="js/jquery-1.12.4.min.js" ></script>

<script>
    var proviceJson = [{
        name: "素材库",
        city: [{
            name: "测试1",
            districtAndCounty: ["东城区", "西城区", "崇文区", "宣武区", "朝阳区", "丰台区", "石景山区", "海淀区", "门头沟区", "房山区", "通州区", "顺义区", "昌平区", "大兴区", "怀柔区", "平谷区", "密云县", "延庆县", "延庆镇"]
        }]
    }, {
        name: "重庆市",
        city: [{
            name: "重庆市",
            districtAndCounty: ["渝中区", "大渡口区", "江北区", "沙坪坝区", "九龙坡区", "南岸区", "北碚区", "万盛区", "双桥区", "渝北区", "巴南区", "万州区", "涪陵区", "黔江区", "长寿区", "合川市", "永川区市", "江津市", "南川市", "綦江县", "潼南县", "铜梁县", "大足县", "荣昌县", "璧山县", "垫江县", "武隆县", "丰都县", "城口县", "梁平县", "开县", "巫溪县", "巫山县", "奉节县", "云阳县", "忠县", "石柱土家族自治县", "彭水苗族土家族自治县", "酉阳土家族苗族自治县", "秀山土家族苗族自治县"]
        }]
    }, {
        name: "插画",
        city: [{
            name: "石家庄市",
            districtAndCounty: ["长安区", "桥东区", "桥西区", "新华区", "裕华区", "井陉矿区", "辛集市", "藁城市", "晋州市", "新乐市", "鹿泉市", "井陉县", "微水镇", "正定县", "正定镇", "栾城县", "栾城镇", "行唐县", "龙州镇", "灵寿县", "灵寿镇", "高邑县", "高邑镇", "深泽县", "深泽镇", "赞皇县", "赞皇镇", "无极县", "无极镇", "平山县", "平山镇", "元氏县", "槐阳镇", "赵县", "赵州镇"]
        }, {
            name: "张家口市",
            districtAndCounty: ["桥西区", "桥东区", "宣化区", "下花园区", "宣化县", "张家口市宣化区", "张北县", "张北镇", "康保县", "康保镇", "沽源县", "平定堡镇", "尚义县", "南壕堑镇", "蔚县", "蔚州镇", "阳原县", "西城镇", "怀安县", "柴沟堡镇", "万全县", "孔家庄镇", "怀来县", "沙城镇", "涿鹿县", "涿鹿镇", "赤城县", "赤城镇", "崇礼县", "西湾子镇"]
        }, {
            name: "承德市",
            districtAndCounty: ["双桥区", "双滦区", "鹰手营子矿区", "承德县", "下板城镇", "兴隆县", "兴隆镇", "平泉县", "平泉镇", "滦平县", "滦平镇", "隆化县", "隆化镇", "丰宁满族自治县", "大阁镇", "宽城满族自治县", "宽城镇", "围场满族蒙古族自治县", "围场镇"]
        }, {
            name: "秦皇岛市",
            districtAndCounty: ["海港区", "山海关区", "北戴河区", "昌黎县", "昌黎镇", "抚宁县", "抚宁镇", "卢龙县", "卢龙镇", "青龙满族自治县", "青龙镇"]
        }]

    }];

    $(document).ready(function(){
        var $province = $("#province");
        var $city = $("#city");
        var $district = $("#district");
        var option = "";
        // 默认禁用城市和区县乡下拉框
        $city.attr("disabled", true);//属性设置为true和disabled都可以
        $district.attr("disabled", "disabled");

        /*
         * 加载所有省份
         */
        for (var i = 0; i < proviceJson.length; i++) {
            option += "<option value=\""+i+"\">"+proviceJson[i].name+"</option>"
        }
        $province.append(option);

        /*
         * 根据省份获取城市
         */
        $province.change(function() {
            option = "<option value=''>--请选择--</option>";
            // 激活城市下拉框
            $city.attr("disabled", false);
            // 清空城市下拉框
            $city.empty();
            // 清空区县乡下拉框，并添加默认"--请选择--"选项
            $district.empty();
            $district.append(option);
            // 获取省份下的城市数组
            var proVal = $(this).val();
            var cityArr = proviceJson[proVal].city;
            for (var i = 0; i < cityArr.length; i++) {
                option += "<option value=\""+i+"\">"+cityArr[i].name+"</option>"
            }
            $city.append(option);
        });


        /*
         * 根据城市获取区县乡
         */
        $city.change(function() {
            // 激活区县乡下拉框
            $district.attr("disabled", false);
            // 获取城市下的区县乡数组
            var proVal = $province.val();
            var cityVal = $(this).val();
            var districtArr = proviceJson[proVal].city[cityVal].districtAndCounty;
            option = "";
            for (var i = 0; i < districtArr.length; i++) {
                option += "<option value=\""+i+"\">"+districtArr[i]+"</option>"
            }
            $district.append(option);
        });

    });

</script>

</body>
</html>

