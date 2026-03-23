package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

/* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001aA\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"unsupportedDirection", "", "lazyLayoutBeyondBoundsModifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "reverseLayout", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;ZLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutBeyondBoundsModifierLocalKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052 A[PHI: r7
      0x0052: PHI (r7v3 androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState) = 
      (r7v1 androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState)
      (r7v4 androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState)
     binds: [B:14:0x0050, B:10:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006c A[PHI: r8
      0x006c: PHI (r8v3 androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo) = 
      (r8v1 androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo)
      (r8v4 androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo)
     binds: [B:24:0x006a, B:20:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087 A[PHI: r9
      0x0087: PHI (r9v3 boolean) = (r9v1 boolean), (r9v4 boolean) binds: [B:34:0x0085, B:30:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4 A[PHI: r10
      0x00a4: PHI (r10v3 androidx.compose.ui.unit.LayoutDirection) = (r10v1 androidx.compose.ui.unit.LayoutDirection), (r10v4 androidx.compose.ui.unit.LayoutDirection) binds: [B:44:0x00a2, B:40:0x009b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c0 A[PHI: r3
      0x00c0: PHI (r3v26 androidx.compose.foundation.gestures.Orientation) = (r3v24 androidx.compose.foundation.gestures.Orientation), (r3v27 androidx.compose.foundation.gestures.Orientation) binds: [B:54:0x00be, B:50:0x00b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.Modifier lazyLayoutBeyondBoundsModifier(androidx.compose.ui.Modifier r15, androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState r16, androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo r17, boolean r18, androidx.compose.ui.unit.LayoutDirection r19, androidx.compose.foundation.gestures.Orientation r20, boolean r21, androidx.compose.runtime.Composer r22, int r23) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState, androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo, boolean, androidx.compose.ui.unit.LayoutDirection, androidx.compose.foundation.gestures.Orientation, boolean, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void unsupportedDirection() {
        throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction".toString());
    }
}
