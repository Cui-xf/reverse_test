package androidx.compose.material3;

import androidx.compose.material3.internal.DateInputFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* compiled from: DateInput.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J.\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u00060 j\u0002`!ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/material3/DateInputValidator;", "", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "errorDatePattern", "", "errorDateOutOfYearRange", "errorInvalidNotAllowed", "errorInvalidRangeInput", "currentStartDateMillis", "", "currentEndDateMillis", "(Lkotlin/ranges/IntRange;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/DateInputFormat;Landroidx/compose/material3/DatePickerFormatter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getCurrentEndDateMillis$material3_release", "()Ljava/lang/Long;", "setCurrentEndDateMillis$material3_release", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCurrentStartDateMillis$material3_release", "setCurrentStartDateMillis$material3_release", "validate", "dateToValidate", "Landroidx/compose/material3/internal/CalendarDate;", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "validate-XivgLIo", "(Landroidx/compose/material3/internal/CalendarDate;ILjava/util/Locale;)Ljava/lang/String;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DateInputValidator {
    public static final int $stable = 0;
    private Long currentEndDateMillis;
    private Long currentStartDateMillis;
    private final DatePickerFormatter dateFormatter;
    private final DateInputFormat dateInputFormat;
    private final String errorDateOutOfYearRange;
    private final String errorDatePattern;
    private final String errorInvalidNotAllowed;
    private final String errorInvalidRangeInput;
    private final SelectableDates selectableDates;
    private final IntRange yearRange;

    public DateInputValidator(IntRange yearRange, SelectableDates selectableDates, DateInputFormat dateInputFormat, DatePickerFormatter dateFormatter, String errorDatePattern, String errorDateOutOfYearRange, String errorInvalidNotAllowed, String errorInvalidRangeInput, Long currentStartDateMillis, Long currentEndDateMillis) {
        this.yearRange = yearRange;
        this.selectableDates = selectableDates;
        this.dateInputFormat = dateInputFormat;
        this.dateFormatter = dateFormatter;
        this.errorDatePattern = errorDatePattern;
        this.errorDateOutOfYearRange = errorDateOutOfYearRange;
        this.errorInvalidNotAllowed = errorInvalidNotAllowed;
        this.errorInvalidRangeInput = errorInvalidRangeInput;
        this.currentStartDateMillis = currentStartDateMillis;
        this.currentEndDateMillis = currentEndDateMillis;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DateInputValidator(IntRange intRange, SelectableDates selectableDates, DateInputFormat dateInputFormat, DatePickerFormatter datePickerFormatter, String str, String str2, String str3, String str4, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Long l3;
        l = (i & 256) != 0 ? null : l;
        if ((i & 512) == 0) {
            l3 = l2;
        } else {
            l3 = null;
        }
        this(intRange, selectableDates, dateInputFormat, datePickerFormatter, str, str2, str3, str4, l, l3);
    }

    /* renamed from: getCurrentStartDateMillis$material3_release, reason: from getter */
    public final Long getCurrentStartDateMillis() {
        return this.currentStartDateMillis;
    }

    public final void setCurrentStartDateMillis$material3_release(Long l) {
        this.currentStartDateMillis = l;
    }

    /* renamed from: getCurrentEndDateMillis$material3_release, reason: from getter */
    public final Long getCurrentEndDateMillis() {
        return this.currentEndDateMillis;
    }

    public final void setCurrentEndDateMillis$material3_release(Long l) {
        this.currentEndDateMillis = l;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6  */
    /* renamed from: validate-XivgLIo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m2012validateXivgLIo(androidx.compose.material3.internal.CalendarDate r13, int r14, java.util.Locale r15) {
        /*
            r12 = this;
            java.lang.String r0 = "format(this, *args)"
            r1 = 0
            r2 = 1
            if (r13 != 0) goto L2a
            java.lang.String r3 = r12.errorDatePattern
            androidx.compose.material3.internal.DateInputFormat r4 = r12.dateInputFormat
            java.lang.String r4 = r4.getPatternWithDelimiters()
            java.util.Locale r5 = java.util.Locale.ROOT
            java.lang.String r4 = r4.toUpperCase(r5)
            java.lang.String r5 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r5[r1] = r4
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r5, r2)
            java.lang.String r1 = java.lang.String.format(r3, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            return r1
        L2a:
            kotlin.ranges.IntRange r3 = r12.yearRange
            int r4 = r13.getYear()
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L68
            java.lang.String r3 = r12.errorDateOutOfYearRange
            kotlin.ranges.IntRange r4 = r12.yearRange
            int r5 = r4.getFirst()
            r9 = 7
            r10 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r4 = androidx.compose.material3.CalendarLocale_jvmKt.toLocalString$default(r5, r6, r7, r8, r9, r10)
            kotlin.ranges.IntRange r5 = r12.yearRange
            int r6 = r5.getLast()
            r10 = 7
            r11 = 0
            r9 = 0
            java.lang.String r5 = androidx.compose.material3.CalendarLocale_jvmKt.toLocalString$default(r6, r7, r8, r9, r10, r11)
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r1] = r4
            r7[r2] = r5
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r7, r6)
            java.lang.String r1 = java.lang.String.format(r3, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            return r1
        L68:
            androidx.compose.material3.SelectableDates r3 = r12.selectableDates
            r4 = 0
            int r5 = r13.getYear()
            boolean r5 = r3.isSelectableYear(r5)
            if (r5 == 0) goto Lcb
            long r5 = r13.getUtcTimeMillis()
            boolean r5 = r3.isSelectableDate(r5)
            if (r5 != 0) goto L81
            goto Lcb
        L81:
            androidx.compose.material3.InputIdentifier$Companion r0 = androidx.compose.material3.InputIdentifier.INSTANCE
            int r0 = r0.m2194getStartDateInputJ2x2o4M()
            boolean r0 = androidx.compose.material3.InputIdentifier.m2188equalsimpl0(r14, r0)
            if (r0 == 0) goto La6
            long r0 = r13.getUtcTimeMillis()
            java.lang.Long r2 = r12.currentEndDateMillis
            if (r2 == 0) goto L9d
            long r2 = r2.longValue()
            goto La2
        L9d:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        La2:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto Lc5
        La6:
            androidx.compose.material3.InputIdentifier$Companion r0 = androidx.compose.material3.InputIdentifier.INSTANCE
            int r0 = r0.m2192getEndDateInputJ2x2o4M()
            boolean r0 = androidx.compose.material3.InputIdentifier.m2188equalsimpl0(r14, r0)
            if (r0 == 0) goto Lc8
            long r0 = r13.getUtcTimeMillis()
            java.lang.Long r2 = r12.currentStartDateMillis
            if (r2 == 0) goto Lbf
            long r2 = r2.longValue()
            goto Lc1
        Lbf:
            r2 = -9223372036854775808
        Lc1:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto Lc8
        Lc5:
            java.lang.String r0 = r12.errorInvalidRangeInput
            return r0
        Lc8:
            java.lang.String r0 = ""
            return r0
        Lcb:
            java.lang.String r5 = r12.errorInvalidNotAllowed
            androidx.compose.material3.DatePickerFormatter r6 = r12.dateFormatter
            long r7 = r13.getUtcTimeMillis()
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r10 = 4
            r11 = 0
            r9 = 0
            r8 = r15
            java.lang.String r15 = androidx.compose.material3.DatePickerFormatter.CC.formatDate$default(r6, r7, r8, r9, r10, r11)
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r6[r1] = r15
            java.lang.Object[] r15 = java.util.Arrays.copyOf(r6, r2)
            java.lang.String r15 = java.lang.String.format(r5, r15)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r0)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputValidator.m2012validateXivgLIo(androidx.compose.material3.internal.CalendarDate, int, java.util.Locale):java.lang.String");
    }
}
