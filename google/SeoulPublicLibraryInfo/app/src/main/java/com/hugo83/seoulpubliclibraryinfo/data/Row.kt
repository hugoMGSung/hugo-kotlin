package com.hugo83.seoulpubliclibraryinfo.data

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

data class Row (
    val ADRES: String,
    val CHARGER_EMAIL: String,
    val CODE_VALUE: String,
    val FDRM_CLOSE_DATE: String,
    val FLOOR_DC: String,
    val FOND_YEAR: String,
    val FXNUM: String,
    val GU_CODE: String,
    val HMPG_URL: String,
    val LBRRY_INTRCN: String,
    val LBRRY_NAME: String,
    val LBRRY_SEQ_NO: String,
    val LBRRY_SE_NAME: String,
    val LON_GDCC: String,
    val MBER_SBSCRB_RQISIT: String,
    val OP_TIME: String,
    val TEL_NO: String,
    val TFCMN: String,
    val XCNTS: String,
    val YDNTS: String
) : ClusterItem { // 데이터클래스에 ClusterItem을 추가하고 필수메서드를 오버라이드
    override fun getPosition(): LatLng {
        return LatLng(XCNTS.toDouble(), YDNTS.toDouble()) // 개별 마커가 표시될 좌표
    }
    override fun getTitle(): String? {
        return LBRRY_NAME
    }
    override fun getSnippet(): String? {
        return ADRES
    }
    override fun hashCode(): Int {
        return LBRRY_SEQ_NO.toInt()
    }
}
