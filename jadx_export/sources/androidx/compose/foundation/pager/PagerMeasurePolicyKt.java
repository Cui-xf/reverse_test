package androidx.compose.foundation.pager;

import kotlin.Metadata;

/* compiled from: PagerMeasurePolicy.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a¡\u0001\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"rememberPagerMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "pageCount", "rememberPagerMeasurePolicy-8u0NR3k", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerMeasurePolicyKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012d A[PHI: r15
      0x012d: PHI (r15v7 kotlin.jvm.functions.Function0<java.lang.Integer>) = (r15v5 kotlin.jvm.functions.Function0<java.lang.Integer>), (r15v8 kotlin.jvm.functions.Function0<java.lang.Integer>) binds: [B:102:0x012b, B:98:0x0124] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014d A[PHI: r6
      0x014d: PHI (r6v14 int) = (r6v12 int), (r6v15 int) binds: [B:112:0x014b, B:108:0x0141] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0176 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038 A[PHI: r8
      0x0038: PHI (r8v3 androidx.compose.foundation.pager.PagerState) = (r8v1 androidx.compose.foundation.pager.PagerState), (r8v4 androidx.compose.foundation.pager.PagerState) binds: [B:12:0x0036, B:8:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0052 A[PHI: r10
      0x0052: PHI (r10v3 androidx.compose.foundation.layout.PaddingValues) = (r10v1 androidx.compose.foundation.layout.PaddingValues), (r10v4 androidx.compose.foundation.layout.PaddingValues) binds: [B:22:0x0050, B:18:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d A[PHI: r11
      0x006d: PHI (r11v3 boolean) = (r11v1 boolean), (r11v4 boolean) binds: [B:32:0x006b, B:28:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008a A[PHI: r4
      0x008a: PHI (r4v20 androidx.compose.foundation.gestures.Orientation) = (r4v18 androidx.compose.foundation.gestures.Orientation), (r4v21 androidx.compose.foundation.gestures.Orientation) binds: [B:42:0x0088, B:38:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a6 A[PHI: r9
      0x00a6: PHI (r9v11 androidx.compose.ui.Alignment$Horizontal) = (r9v8 androidx.compose.ui.Alignment$Horizontal), (r9v12 androidx.compose.ui.Alignment$Horizontal) binds: [B:52:0x00a4, B:48:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c2 A[PHI: r12
      0x00c2: PHI (r12v12 androidx.compose.ui.Alignment$Vertical) = (r12v9 androidx.compose.ui.Alignment$Vertical), (r12v13 androidx.compose.ui.Alignment$Vertical) binds: [B:62:0x00c0, B:58:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00de A[PHI: r13
      0x00de: PHI (r13v12 float) = (r13v9 float), (r13v13 float) binds: [B:72:0x00dc, B:68:0x00d6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fa A[PHI: r14
      0x00fa: PHI (r14v12 androidx.compose.foundation.pager.PageSize) = (r14v9 androidx.compose.foundation.pager.PageSize), (r14v13 androidx.compose.foundation.pager.PageSize) binds: [B:82:0x00f8, B:78:0x00f2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0114 A[PHI: r5
      0x0114: PHI (r5v8 androidx.compose.foundation.gestures.snapping.SnapPosition) = 
      (r5v6 androidx.compose.foundation.gestures.snapping.SnapPosition)
      (r5v9 androidx.compose.foundation.gestures.snapping.SnapPosition)
     binds: [B:92:0x0112, B:88:0x010b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011e  */
    /* renamed from: rememberPagerMeasurePolicy-8u0NR3k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.jvm.functions.Function2<androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Constraints, androidx.compose.ui.layout.MeasureResult> m931rememberPagerMeasurePolicy8u0NR3k(final kotlin.jvm.functions.Function0<androidx.compose.foundation.pager.PagerLazyLayoutItemProvider> r24, androidx.compose.foundation.pager.PagerState r25, androidx.compose.foundation.layout.PaddingValues r26, boolean r27, androidx.compose.foundation.gestures.Orientation r28, int r29, float r30, androidx.compose.foundation.pager.PageSize r31, androidx.compose.ui.Alignment.Horizontal r32, androidx.compose.ui.Alignment.Vertical r33, androidx.compose.foundation.gestures.snapping.SnapPosition r34, final kotlinx.coroutines.CoroutineScope r35, kotlin.jvm.functions.Function0<java.lang.Integer> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerMeasurePolicyKt.m931rememberPagerMeasurePolicy8u0NR3k(kotlin.jvm.functions.Function0, androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.Orientation, int, float, androidx.compose.foundation.pager.PageSize, androidx.compose.ui.Alignment$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.snapping.SnapPosition, kotlinx.coroutines.CoroutineScope, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):kotlin.jvm.functions.Function2");
    }
}
