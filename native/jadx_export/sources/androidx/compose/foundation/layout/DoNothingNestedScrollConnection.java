package androidx.compose.foundation.layout;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: WindowInsetsConnection.android.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/DoNothingNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "()V", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DoNothingNestedScrollConnection implements NestedScrollConnection {
    public static final DoNothingNestedScrollConnection INSTANCE = new DoNothingNestedScrollConnection();

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    public /* synthetic */ Object mo476onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        return NestedScrollConnection.CC.m5273onPostFlingRZ2iAVY$suspendImpl(this, j, j2, continuation);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public /* synthetic */ long mo477onPostScrollDzOQY0M(long j, long j2, int i) {
        return NestedScrollConnection.CC.m5266$default$onPostScrollDzOQY0M(this, j, j2, i);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    public /* synthetic */ Object mo478onPreFlingQWom1Mo(long j, Continuation continuation) {
        return NestedScrollConnection.CC.m5274onPreFlingQWom1Mo$suspendImpl(this, j, continuation);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public /* synthetic */ long mo479onPreScrollOzD1aCk(long j, int i) {
        return NestedScrollConnection.CC.m5268$default$onPreScrollOzD1aCk(this, j, i);
    }

    private DoNothingNestedScrollConnection() {
    }
}
