package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import kotlin.Metadata;

/* compiled from: TextFieldMagnifier.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-hUlJWOE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;J)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldMagnifierKt {

    /* compiled from: TextFieldMagnifier.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.Cursor.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Handle.SelectionStart.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Handle.SelectionEnd.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00d5  */
    /* renamed from: calculateSelectionMagnifierCenterAndroid-hUlJWOE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long m1247calculateSelectionMagnifierCenterAndroidhUlJWOE(androidx.compose.foundation.text.input.internal.TransformedTextFieldState r23, androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r24, androidx.compose.foundation.text.input.internal.TextLayoutState r25, long r26) {
        /*
            long r0 = r24.m1271getHandleDragPositionF1C5BW0()
            boolean r2 = androidx.compose.ui.geometry.OffsetKt.m3966isUnspecifiedk4lQ0M(r0)
            if (r2 != 0) goto Le6
            androidx.compose.foundation.text.input.TextFieldCharSequence r2 = r23.getVisualText()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L18
            r2 = 1
            goto L19
        L18:
            r2 = 0
        L19:
            if (r2 == 0) goto L20
            r15 = r0
            r0 = r25
            goto Le9
        L20:
            androidx.compose.foundation.text.input.TextFieldCharSequence r2 = r23.getVisualText()
            long r2 = r2.getSelection()
            androidx.compose.foundation.text.Handle r4 = r24.getDraggingHandle()
            if (r4 != 0) goto L30
            r4 = -1
            goto L38
        L30:
            int[] r5 = androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierKt.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r5[r4]
        L38:
            switch(r4) {
                case -1: goto Ldf;
                case 0: goto L3b;
                case 1: goto L46;
                case 2: goto L46;
                case 3: goto L41;
                default: goto L3b;
            }
        L3b:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L41:
            int r4 = androidx.compose.ui.text.TextRange.m6141getEndimpl(r2)
            goto L4a
        L46:
            int r4 = androidx.compose.ui.text.TextRange.m6146getStartimpl(r2)
        L4a:
            androidx.compose.ui.text.TextLayoutResult r5 = r25.getLayoutResult()
            if (r5 != 0) goto L58
            androidx.compose.ui.geometry.Offset$Companion r5 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r5 = r5.m3960getUnspecifiedF1C5BW0()
            return r5
        L58:
            float r6 = androidx.compose.ui.geometry.Offset.m3945getXimpl(r0)
            int r7 = r5.getLineForOffset(r4)
            float r8 = r5.getLineLeft(r7)
            float r9 = r5.getLineRight(r7)
            float r10 = java.lang.Math.min(r8, r9)
            float r11 = java.lang.Math.max(r8, r9)
            float r12 = kotlin.ranges.RangesKt.coerceIn(r6, r10, r11)
            androidx.compose.ui.unit.IntSize$Companion r13 = androidx.compose.ui.unit.IntSize.INSTANCE
            long r13 = r13.m6872getZeroYbymL2g()
            r15 = r0
            r0 = r26
            boolean r13 = androidx.compose.ui.unit.IntSize.m6865equalsimpl0(r0, r13)
            if (r13 != 0) goto L9b
            float r13 = r6 - r12
            float r13 = java.lang.Math.abs(r13)
            int r14 = androidx.compose.ui.unit.IntSize.m6867getWidthimpl(r0)
            int r14 = r14 / 2
            float r14 = (float) r14
            int r13 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r13 <= 0) goto L9b
            androidx.compose.ui.geometry.Offset$Companion r13 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r13 = r13.m3960getUnspecifiedF1C5BW0()
            return r13
        L9b:
            float r13 = r5.getLineTop(r7)
            float r14 = r5.getLineBottom(r7)
            float r17 = r14 - r13
            r18 = 1073741824(0x40000000, float:2.0)
            float r17 = r17 / r18
            float r0 = r17 + r13
            r17 = 0
            r19 = r2
            long r1 = androidx.compose.ui.geometry.OffsetKt.Offset(r12, r0)
            androidx.compose.ui.layout.LayoutCoordinates r3 = r25.getTextLayoutNodeCoordinates()
            if (r3 == 0) goto Ld5
            r17 = r3
            r18 = 0
            boolean r17 = r17.isAttached()
            if (r17 == 0) goto Lc4
            goto Lc5
        Lc4:
            r3 = 0
        Lc5:
            if (r3 == 0) goto Ld5
            r17 = 0
            r18 = r0
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r3)
            long r1 = androidx.compose.foundation.text.input.internal.TextLayoutStateKt.m1222coerceIn3MmeM6k(r1, r0)
            goto Ld7
        Ld5:
            r18 = r0
        Ld7:
            r0 = r25
            long r21 = androidx.compose.foundation.text.input.internal.TextLayoutStateKt.m1224fromTextLayoutToCoreUv8p0NA(r0, r1)
            return r21
        Ldf:
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r1 = r1.m3960getUnspecifiedF1C5BW0()
            return r1
        Le6:
            r15 = r0
            r0 = r25
        Le9:
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r1 = r1.m3960getUnspecifiedF1C5BW0()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierKt.m1247calculateSelectionMagnifierCenterAndroidhUlJWOE(androidx.compose.foundation.text.input.internal.TransformedTextFieldState, androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState, androidx.compose.foundation.text.input.internal.TextLayoutState, long):long");
    }
}
