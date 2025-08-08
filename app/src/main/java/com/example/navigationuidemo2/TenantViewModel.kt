package com.example.navigationuidemo2

import androidx.lifecycle.*

class TenantViewModel : ViewModel() {
    private val _tenantInfo = MutableLiveData("")
    val tenantInfo: LiveData<String> = _tenantInfo

    // Bonus: Tenant counter
    private val _tenantCount = MutableLiveData(0)
    val tenantCount: LiveData<Int> = _tenantCount

    // Uppercase transformation using map
    val capitalizedTenantInfo: LiveData<String> = tenantInfo.map { it.uppercase() }

    fun addTenant(name: String, unit: String, rent: String) {
        val newEntry = "Name: $name\nUnit: $unit\nRent: $rent\n\n"
        _tenantInfo.value = (_tenantInfo.value ?: "") + newEntry
        
        // Increment tenant count
        _tenantCount.value = (_tenantCount.value ?: 0) + 1
    }
}