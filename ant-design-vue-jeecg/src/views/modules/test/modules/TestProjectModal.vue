<template>
  <a-modal
    :title="title"
    :width="800"
    :visible="visible"
    :confirmLoading="confirmLoading"
    @ok="handleOk"
    @cancel="handleCancel"
    cancelText="关闭">
    
    <a-spin :spinning="confirmLoading">
      <a-form :form="form">
      
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="名称">
          <a-input placeholder="请输入名称" v-decorator="['name', validatorRules.name ]" />
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="被检测公司ID">
          <a-input placeholder="请输入被检测公司ID" v-decorator="['companyId', validatorRules.companyId ]" />
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="被检测公司名称">
          <a-input placeholder="请输入被检测公司名称" v-decorator="['companyName', validatorRules.companyName ]" />
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="实验室ID">
          <a-input placeholder="请输入实验室ID" v-decorator="['laboratoryId', validatorRules.laboratoryId ]" />
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="实验室名称">
          <a-input placeholder="请输入实验室名称" v-decorator="['laboratoryName', validatorRules.laboratoryName ]" />
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="产品ID">
          <a-input placeholder="请输入产品ID" v-decorator="['productId', validatorRules.productId ]" />
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="型号ID">
          <a-input placeholder="请输入型号ID" v-decorator="['modelId', validatorRules.modelId ]" />
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="认证ID">
          <a-input placeholder="请输入认证ID" v-decorator="['certificationId', validatorRules.certificationId ]" />
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="标准ID">
          <a-input placeholder="请输入标准ID" v-decorator="['standardId', validatorRules.standardId ]" />
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="条款结论ID">
          <a-input placeholder="请输入条款结论ID" v-decorator="['clauseResultId', {}]" />
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="描述">
          <a-input placeholder="请输入描述" v-decorator="['content', {}]" />
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="删除状态（0，正常，1已删除）">
          <a-input placeholder="请输入删除状态（0，正常，1已删除）" v-decorator="['delFlag', {}]" />
        </a-form-item>
		
      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>
  import { httpAction } from '@/api/manage'
  import pick from 'lodash.pick'
  import moment from "moment"

  export default {
    name: "TestProjectModal",
    data () {
      return {
        title:"操作",
        visible: false,
        model: {},
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },

        confirmLoading: false,
        form: this.$form.createForm(this),
        validatorRules:{
        name:{rules: [{ required: true, message: '请输入名称!' }]},
        companyId:{rules: [{ required: true, message: '请输入被检测公司ID!' }]},
        companyName:{rules: [{ required: true, message: '请输入被检测公司名称!' }]},
        laboratoryId:{rules: [{ required: true, message: '请输入实验室ID!' }]},
        laboratoryName:{rules: [{ required: true, message: '请输入实验室名称!' }]},
        productId:{rules: [{ required: true, message: '请输入产品ID!' }]},
        modelId:{rules: [{ required: true, message: '请输入型号ID!' }]},
        certificationId:{rules: [{ required: true, message: '请输入认证ID!' }]},
        standardId:{rules: [{ required: true, message: '请输入标准ID!' }]},
        },
        url: {
          add: "/test/testProject/add",
          edit: "/test/testProject/edit",
        },
      }
    },
    created () {
    },
    methods: {
      add () {
        this.edit({});
      },
      edit (record) {
        this.form.resetFields();
        this.model = Object.assign({}, record);
        this.visible = true;
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model,'name','companyId','companyName','laboratoryId','laboratoryName','productId','modelId','certificationId','standardId','clauseResultId','content','delFlag'))
		  //时间格式化
        });

      },
      close () {
        this.$emit('close');
        this.visible = false;
      },
      handleOk () {
        const that = this;
        // 触发表单验证
        this.form.validateFields((err, values) => {
          if (!err) {
            that.confirmLoading = true;
            let httpurl = '';
            let method = '';
            if(!this.model.id){
              httpurl+=this.url.add;
              method = 'post';
            }else{
              httpurl+=this.url.edit;
               method = 'put';
            }
            let formData = Object.assign(this.model, values);
            //时间格式化
            
            console.log(formData)
            httpAction(httpurl,formData,method).then((res)=>{
              if(res.success){
                that.$message.success(res.message);
                that.$emit('ok');
              }else{
                that.$message.warning(res.message);
              }
            }).finally(() => {
              that.confirmLoading = false;
              that.close();
            })



          }
        })
      },
      handleCancel () {
        this.close()
      },


    }
  }
</script>

<style lang="less" scoped>

</style>