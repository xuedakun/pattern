package cn.com.pattern.builder.contract;

/**
 * 保险合同对象
 */
public class InsuranceContract {
	// 保险合同编号
	private String contractId;
	/**
	 * 被保险人员的名称，同一份保险合同，要么跟人员签订，要么跟公司签订 也就是说，“被保险人员”和“被保险公司”这两个属性，不可能同时有值
	 */
	private String personName;
	// 被保险公司的名称
	private String companyName;
	// 保险开始生效日期
	private long beginDate;
	// 保险失效日期，一定会大于保险开始生效日期
	private long endDate;
	// 其他数据
	private String otherData;
	

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(long beginDate) {
		this.beginDate = beginDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public String getOtherData() {
		return otherData;
	}

	public void setOtherData(String otherData) {
		this.otherData = otherData;
	}

	// 私有构造方法
	private InsuranceContract(ConcreteBuilder builder) {
		this.contractId = builder.contractId;
		this.personName = builder.personName;
		this.companyName = builder.companyName;
		this.beginDate = builder.beginDate;
		this.endDate = builder.endDate;
		this.otherData = builder.otherData;
	}

	/**
	 * 保险合同的一些操作
	 */
	public void someOperation() {
		System.out.println("当前正在操作的保险合同编号为【" + this.contractId + "】");
	}

	public static class ConcreteBuilder {
		private String contractId;
		private String personName;
		private String companyName;
		private long beginDate;
		private long endDate;
		private String otherData;

		/**
		 * 构造方法，传入必须要有的参数
		 * 
		 * @param contractId
		 *            保险合同编号
		 * @param beginDate
		 *            保险合同开始生效日期
		 * @param endDate
		 *            保险合同失效日期
		 */
		public ConcreteBuilder(String contractId, long beginDate, long endDate) {
			this.contractId = contractId;
			this.beginDate = beginDate;
			this.endDate = endDate;
		}

		// 被保险人员的名称
		public ConcreteBuilder setPersonName(String personName) {
			this.personName = personName;
			return this;
		}

		// 被保险公司的名称
		public ConcreteBuilder setCompanyName(String companyName) {
			this.companyName = companyName;
			return this;
		}

		// 其他数据
		public ConcreteBuilder setOtherData(String otherData) {
			this.otherData = otherData;
			return this;
		}

		/**
		 * 构建真正的对象并返回
		 * 
		 * @return 构建的保险合同对象
		 */
		public InsuranceContract build() {
			if (contractId == null || contractId.trim().length() == 0) {
				throw new IllegalArgumentException("合同编号不能为空");
			}
			boolean signPerson = (personName != null && personName.trim().length() > 0);
			boolean signCompany = (companyName != null && companyName.trim().length() > 0);
			if (signPerson && signCompany) {
				throw new IllegalArgumentException("一份保险合同不能同时与个人和公司签订");
			}
			if (signPerson == false && signCompany == false) {
				throw new IllegalArgumentException("一份保险合同不能没有签订对象");
			}
			if (beginDate <= 0) {
				throw new IllegalArgumentException("一份保险合同必须有开始生效的日期");
			}
			if (endDate <= 0) {
				throw new IllegalArgumentException("一份保险合同必须有失效的日期");
			}
			if (endDate < beginDate) {
				throw new IllegalArgumentException("一份保险合同的失效日期必须大于生效日期");
			}
			return new InsuranceContract(this);
		}
	}
}
